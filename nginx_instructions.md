# 🌐 Nexus Galactic Fleet - Load Balancing with Nginx

This guide explains how to deploy, configure, and test the production-grade Nginx Reverse Proxy in front of our multi-instance Spring Boot application.

---

## 🛠️ 1. Nginx Installation & Setup (Windows)

1. **Download Nginx:**
   Go to [http://nginx.org/en/download.html](http://nginx.org/en/download.html) and download the latest Mainline version for Windows (e.g., `nginx-1.25.x.zip`).
2. **Extract:**
   Extract the zip file to `C:\nginx` (or any preferred directory).
3. **Apply Configuration:**
   Copy the provided `nginx.conf` file from the root of this project and replace the default file located at `C:\nginx\conf\nginx.conf`.
4. **Start Nginx:**
   Open Command Prompt, navigate to `C:\nginx`, and run:
   ```cmd
   start nginx
   ```
   *(To stop it later, run `nginx -s quit` or `nginx -s stop`)*

---

## ⚙️ 2. Production-Ready Configuration Details

The provided `nginx.conf` has been hardened for production environments:

* **Upstream Cluster (`backend_cluster`):** Routes traffic to `localhost:8081`, `8082`, and `8083`.
* **Health Checks (`max_fails=3 fail_timeout=10s`):** If an instance fails 3 times, Nginx marks it as "down" for 10 seconds before retrying it.
* **Keep-Alive Connections (`keepalive 32`):** Maintains persistent TCP connections to the backends to avoid connection setup overhead per request.
* **Header Propagation:**
  ```nginx
  proxy_set_header X-Real-IP $remote_addr;
  proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
  proxy_set_header X-Correlation-ID $http_x_correlation_id;
  ```
  *(Crucial for propagating the Correlation ID and Client IP through to the backend MDC).*
* **Custom JSON Errors:** Converts ugly Nginx HTML error pages (502/503/504) into clean, standard JSON identical in style to our Spring Boot backend.

---

## 🔁 3. Retry & Failover Strategy

Nginx is configured to **transparently failover**:
```nginx
proxy_next_upstream error timeout invalid_header http_500 http_502 http_503 http_504;
proxy_next_upstream_tries 3;
```
**What this means:** 
If `localhost:8081` crashes or times out while processing a request, Nginx will instantly catch the error and silently route the same request to `localhost:8082`. **The user will never see the error.** They will simply experience a slightly longer response time.

---

## 🧪 4. Testing Scenarios

### 🟢 Scenario 1: Normal Round-Robin Load Balancing
**Setup:** Run all 3 Spring Boot instances + Nginx.
**Test:** Use Postman or JMeter to send 5 `POST http://localhost/api/starships` requests (Notice it's just `localhost` now, port 80!).
**Expected Result:** The `servedBy` field in the response JSON will cleanly rotate:
* Request 1: `"servedBy": "instance-1"`
* Request 2: `"servedBy": "instance-2"`
* Request 3: `"servedBy": "instance-3"`
* Request 4: `"servedBy": "instance-1"`

### 🔴 Scenario 2: Instance Crash (Seamless Failover)
**Setup:** While hitting the API continuously, kill the terminal running `instance-2` (Port 8082).
**Expected Result:** 
* No requests fail on the client side!
* The responses will automatically shift to alternating only between `"servedBy": "instance-1"` and `"servedBy": "instance-3"`.
* If you check `C:\nginx\logs\error.log`, you will see Nginx silently logging connection failures to 8082, but proxying to the next upstream successfully.

### 💀 Scenario 3: Complete Cluster Outage (All Instances Down)
**Setup:** Kill all 3 Spring Boot instances.
**Test:** Send a GET or POST request to `http://localhost/api/starships`.
**Expected Result (Nginx Error Response):**
```json
{
  "error": "Service temporarily unavailable",
  "message": "Please try again later"
}
```

---

## 🪵 5. Example Logs (Traceability)

### Success (Backend Log):
Notice how the Client IP and Correlation ID flow securely from Nginx into the Backend MDC:
```text
[2024-04-02 12:00:00.015] [INFO ] [f78d91a2-b43e-43cd-8a21-998811aabbcc] [http-nio-8081-exec-1] [c.e.s.C.s.i.StarshipServiceImpl] [instance-1] : Auto-generated unique registry number: US-4219
```

### Success (Nginx Access Log `logs/access.log`):
```text
[02/Apr/2024:12:00:00 -0500] [Client: 127.0.0.1] [CorrID: f78d91a2-b43e-43cd-8a21-998811aabbcc] "POST /api/starships HTTP/1.1" 201 1204 [Upstream: 127.0.0.1:8081] [ResponseTime: 0.142 s]
```

### Backend Error Response (Passed through Nginx unchanged):
If the database fails or validation fails on `instance-3`, Nginx will pass the JSON back exactly as Spring formulated it:
```json
{
  "timestamp": "2024-04-02T12:05:10",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Database connection refused",
  "path": "/api/starships",
  "meta": {
    "servedBy": "instance-3",
    "port": "8083",
    "correlationId": "abc123xyz"
  }
}
```

---

## 📊 6. Simulating High Load

To truly test the load balancer's mettle, use **Apache JMeter**:
1. Download JMeter and create a Thread Group.
2. Set **Number of Threads (users)** to `1000` and **Ramp-up period** to `10` seconds.
3. Add an HTTP Request Sampler targeting `POST http://localhost/api/starships`.
4. Run the test.
5. Check the Spring Boot consoles—you will see a massive flurry of logs distributed perfectly evenly across all three terminal windows, with zero dropped requests.

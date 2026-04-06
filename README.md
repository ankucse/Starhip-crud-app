<div align="center">
  <img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExMjM4ZmFkM2E1MjM4ZmFkM2E1MjM4ZmFkM2E1MjM4ZmFkM2E1MjM4ZiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PWc/3o7TKrEzvLbsVAud8I/giphy.gif" alt="Sci-Fi Starship Dashboard" width="600"/>

  # 🌌 Nexus Galactic Fleet API 🚀

  **A Next-Generation, Fully Automated Starship Generator and Management System** <br>
  *Built with Java 21, Spring Boot 3, and MongoDB*

  [![Java](https://img.shields.io/badge/Java-21%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)]()
  [![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.2-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)]()
  [![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)]()
  [![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)]()
  
</div>

---

## 🛸 What is the Nexus Galactic Fleet API?

Welcome, Commander. The **Nexus Galactic Fleet API** is not just another CRUD application—it is a **procedural starship manufacturing engine**. 

Instead of painstakingly entering manual data for hundreds of ship specifications, this API leverages a **Procedural Generation Core** to instantly forge fully-realized, production-grade Starships. Each ship comes complete with over **100+ meticulously calculated data points**, nested across 10 distinct sub-systems.

From `Warp Core Output` to `Astrometric Sensor Types` to `Cargo Refrigeration Capacity`—every time you hit the forge, a unique vessel is born.

---

## ✨ Features

* 🤖 **Zero-Touch Generation**: Simply hit the `POST` endpoint and watch as the API generates a colossal, 100+ field Starship entity dynamically.
* 🌍 **Faction-Aligned Lore**: Ships are automatically aligned to terrestrial factions (`US`, `JPN`, `IND`, `GER`, `UK`, `FRA`), generating lore-accurate names, homeports, and crew registries.
* ♾️ **Infinite Diversity**: Utilizes a custom `StarshipGenerator` holding **1,000 unique variations** for almost every single subsystem component.
* 📦 **Complex MongoDB Documents**: Implements advanced `@Document` design with 10 `@Data` sub-collections per ship.
* 🛡️ **Enterprise Architecture**: Strict Layered Design (Controller → Service → Repository), DTO Mapping, and Global Exception Handling.

---

## 🏗️ System Architecture

The Starship domain is broken down into **10 Core Sub-Systems**:

1. 👨‍✈️ **Crew Details** *(Captains, Officers, Security, Enlisted)*
2. 🚀 **Engine Specs** *(Propulsion, Warp Speed, Thrust, Fuel)*
3. 🗺️ **Navigation System** *(Astrometrics, Autopilot, Star Trackers)*
4. ⚔️ **Weaponry** *(Phaser Banks, Torpedoes, Point Defense)*
5. 🌿 **Life Support** *(Oxygen, Temp, Filtration, Water Recycling)*
6. 📡 **Communication** *(Transceivers, Encryption, Distress Beacons)*
7. 📦 **Cargo** *(Capacity, Hazards, Refrigeration, Transporters)*
8. 🔧 **Maintenance** *(Hull Integrity, Repair Drones, Diagnostics)*
9. 🛡️ **Shields** *(Deflector Grids, Regen Rates, Cloaking)*
10. ☢️ **Reactor** *(M/A Assemblies, Core Temps, Radiation Shielding)*

---

## 🚀 Quick Start Guide

### 1. Prerequisites
- **Java 21** installed.
- **MongoDB** running locally on `localhost:27018`.
- **MongoDB Compass** (Optional, but highly recommended for viewing the massive documents).

### 2. Clone & Build
```bash
git clone https://github.com/your-username/nexus-galactic-fleet.git
cd nexus-galactic-fleet
./gradlew build
```

### 3. Launch the Forge
```bash
./gradlew bootRun
```
*The API will start on `http://localhost:8080`*

---

## 📡 API Endpoints

### 🛠️ 1. Forge a New Starship (Auto-Generate)
**`POST /api/starships`**

No payload required! Just hit the endpoint and let the generator do the heavy lifting.

**Response (Snippet):**
```json
{
  "id": "64d0f5c1a3...",
  "registryNumber": "JPN-8319",
  "name": "IJN Tulemo-4",
  "shipClass": "Dreadnought Model-521",
  "faction": "JPN",
  "homePort": "JPN Launch Facility Alpha-81",
  "commissionDate": "1994-11-20",
  "status": "On Mission Model-11",
  "totalMass": 184021.5,
  "engineSpecs": {
    "primaryPropulsionType": "Matter-Antimatter Model-891",
    "maxWarpSpeed": 8.4,
    "cruisingSpeed": 5.2,
    "totalThrust": 310592,
    "fuelType": "Antimatter Model-22",
    ...
  },
  "weaponry": {
    "primaryPhaserBanks": 5,
    "torpedoInventory": 112,
    "primaryWeaponType": "Plasma Cannon Model-841",
    ...
  }
  // ... 90+ more fields!
}
```

### 🔍 2. Retrieve Fleet Database
**`GET /api/starships?page=0&size=10&sortBy=registryNumber`**
*Supports pagination and sorting.*

### 🎯 3. Inspect Specific Vessel
**`GET /api/starships/{id}`**

### 💥 4. Scuttle Vessel (Delete)
**`DELETE /api/starships/{id}`**

*(Note: Manual Updates (`PUT`) are disabled to preserve the integrity of the procedurally generated configurations).*

---

## 🪵 Production Logging

The application features strict SLF4J logging. When a ship is forged, you will see the console light up with the ship's birth details:

<img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExMWEyNjM4ZmFkM2E1MjM4ZmFkM2E1MjM4ZmFkM2E1MjM4ZiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PWc/26tn33aiTi1jIGs1e/giphy.gif" alt="Logs GIF" width="400"/>

```text
[INFO ] StarshipServiceImpl : Entering createStarship() - Generating everything automatically.
[INFO ] StarshipServiceImpl : Auto-generated unique registry number: JPN-8319
[INFO ] StarshipServiceImpl : Faction detected: JPN | Assigned Name: IJN Tulemo-4 | Home Port: JPN Launch Facility Alpha-81
[INFO ] StarshipServiceImpl : Saving auto-generated starship to the database...
[INFO ] StarshipServiceImpl : Starship successfully created with ID: 64d0... and Registry: JPN-8319
[INFO ] StarshipController  : Finished processing create request. Status: 201 CREATED
```

---

<div align="center">
  <i>"To boldly go where no API has gone before."</i>
  <br><br>
  <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License"/>
</div>

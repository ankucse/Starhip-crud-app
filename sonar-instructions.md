# 🚀 Enterprise-Grade SonarQube Setup

## ✅ 1. Quality Gate Definition

Set up a **Custom Quality Gate** in SonarQube by navigating to `Quality Gates` -> `Create`:
* **Overall Code Coverage:** ≥ 90%
* **New Code Coverage:** ≥ 95%
* **Duplicated Lines:** ≤ 3%
* **Code Smells (New Code):** = 0
* **Maintainability Rating:** A
* **Bugs (New Code):** = 0
* **Reliability Rating:** A
* **Vulnerabilities:** = 0
* **Security Rating:** A
* **Security Hotspots Reviewed:** = 100%
* **Technical Debt Ratio:** ≤ 5%

Make sure to mark this gate as **Default**.

## ✅ 2. Gradle Configuration

The `build.gradle` file has been updated to include:
* SonarQube plugin (`org.sonarqube` version `4.0.0.2929`)
* JaCoCo plugin configured to generate reports after testing
* Test task bindings to build and report

*(Check your `build.gradle` file for exact setup).*

## ✅ 3. JaCoCo Setup

JaCoCo plugin has been added and configured:
* Minimal code coverage rule limit of `0.90` explicitly enforced via Gradle tasks.
* Outputs `xml` report which is necessary for SonarQube.

## ✅ 4. Sonar Properties File

A `sonar-project.properties` file has been created.
It contains required mappings:
* `sonar.sources` / `sonar.tests`
* `sonar.coverage.jacoco.xmlReportPaths`

## ✅ 5. CI/CD Example (GitHub Actions)

A GitHub Actions workflow is created at `.github/workflows/sonarqube.yml`.
**Features:**
* Checks out full history (fetch-depth: 0) needed by Sonar.
* Caches `.sonar` and `.gradle` for performance.
* Runs `./gradlew build jacocoTestReport sonar`.
* Runs on PRs and main branch commits.

**To Fail Pipeline on Quality Gate Failures (Recommended for Jenkins or CI):**
In GitHub Actions, Sonar provides a specific check step for waiting on QG status, or you can append `-Dsonar.qualitygate.wait=true` to the sonar command arguments.

## ✅ 6. Best Practices & Bonus 💎

### **Handling "New Code"**
* Go to **Project Settings -> New Code** in SonarQube.
* Select `Previous version` or `Number of days = 30`.

### **Test Coverage Gaps**
* **Exclude Data Classes / DTOs:** DTOs and configuration classes often drag down coverage because they hold no logic. Added default exclusions to your `build.gradle` and `sonar-project.properties`.
* **Writing Meaningful Tests:** Aim for behavior coverage (verifying correct behavior under Mockito) over blind line coverage.

### **Rule Customizations**
* SonarQube has pre-defined profiles ("Sonar way"). It is recommended to create a custom Quality Profile based on it.
* **Enable Extra Rules:** NullPointer checks, unused exceptions, unhandled security contexts, empty `@Catch` blocks.
* **Disable Noise:** Turn off generic Java naming issues if they clash with specific domain language.

### **Security Hardening**
* The Sonar Security plugin (available in Developer Edition and above) checks for SQL Injection, XSS, and unvalidated redirects.
* Keep **Security Hotspots Reviewed** to 100%. A Hotspot means a manual human review is required to confirm it's safe.

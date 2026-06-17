# SauceDemo QA & Automation Testing Project

## 📌 Project Overview
This project delivers a comprehensive quality assurance analysis of the **SauceDemo** e-commerce application. By following the **Software Testing Life Cycle (STLC)**, the project transitions from rigorous manual test case design to an industry-standard automated testing framework using **Selenium WebDriver**, **Java**, and **JUnit 5**.

The primary objective was to evaluate the application's functionality, UI/UX consistency, edge-case robustness, and security policies across various pre-configured user profiles.

---

## 🛠️ Tech Stack & Dependencies
- **Programming Language:** Java (JDK 11+)
- **Testing Framework:** JUnit 5 (Junit Jupiter)
- **Automation Tool:** Selenium WebDriver (v4.18.1)
- **Driver Management:** WebDriverManager (v5.7.0)
- **Build Tool:** Maven

---

## 📋 Testing Strategy & Scope

### 1. Manual Testing & Test Suite Design
A robust **Test Case Suite** consisting of 10 core functional scenarios was meticulously designed in Microsoft Excel. The test scope spans the most critical paths of the user journey:
- **Authentication:** Valid/invalid login flows and empty field handling.
- **Inventory & Browsing:** Product visibility, dynamic sorting logic.
- **Cart Management:** Synchronized item addition and removal.
- **Checkout Process:** Input verification, multi-step ordering, and successful order placements.

### 2. Cross-Profile Quality Analysis
To test system resilience against intentional defects, a cross-profile matrix analysis was executed manually:
- `standard_user`: **PASS**. System is entirely stable.
- `locked_out_user`: **PASS (Security)**. Verified the account lockout policy; unauthorized entry is correctly blocked with a secure error handler.
- `problem_user`: **FAIL (UI)**. Broken unique product images (replaced by identical placeholders) and intermittent button unresponsiveness.
- `performance_glitch_user`: **FAIL (UX)**. Severe server-side delay during authentication, exceeding the 5-second latency threshold.
- `error_user`: **FAIL (Logic)**. Critical functional logic defect in the cart module where click events are dropped, causing empty carts.
- `visual_user`: **FAIL (Visual)**. Misaligned UI elements and CSS layout shifts impacting structural symmetry.

### 3. Boundary Value Analysis (BVA)
During the checkout phase, input data validation was specialized. Entering invalid numeric strings (e.g., `12345` or `Tufan123`) into alpha-only fields like *First Name* and *Last Name* was incorrectly accepted by the platform without error diagnostics, highlighting a clear **Data Validation Issue**.

---

## 🚀 Automation & Unit Testing Architecture
The manual functional base was migrated into an automated testing structure utilizing a **JUnit 5 Unit Testing Framework** instead of standard linear main scripts. 

### Key Engineering Practices:
- **Test Isolation:** Leveraging Junit's `@BeforeEach` and `@AfterEach` lifecycle annotations ensures every unit test starts on a clean, independent browser instance to prevent environment pollution.
- **Dynamic Synchronizations:** Implemented `ImplicitlyWait` drivers rather than static thread sleeps, allowing smart component discovery within a 10-second window.
- **Automated Assertions:** Replaced structural `if-else` console verification with explicit `Assertions.assertEquals` and `Assertions.assertTrue` blocks, ensuring runtime exceptions immediately trigger test failure reports upon mismatches.
- **Resource Management:** Automatic invocation of `driver.quit()` eliminates lingering background chrome processes, guaranteeing optimal local RAM utilization.

---

## 🔍 Executed Automated Test Scripts
The framework automatically executes an optimized **Smoke Test** suite:
1. **`testStandardUserLogin`**: Verifies login routing by explicitly asserting that the redirection dashboard contains the `"Products"` landing header.
2. **`testInventoryVisibility`**: Validates post-login DOM rendering by strictly checking that the core product catalog (`inventory_container`) is fully displayed to the end-user.

---

## 📊 How to Run the Project
1. Clone this repository:
   ```bash
   git clone [https://github.com/your-username/SauceDemoAutomation.git](https://github.com/TufanDuzel/software-testing-project.git)
# LeetCode Automation Test Suite – Selenium & Java

This repository contains automated UI tests for validating key LeetCode user flows using **Java**, **Selenium WebDriver**, and **Gradle**.
It was developed as part of my **Fellowship program with Crio** and includes complete, browser-driven test scenarios.

---

## 📌 Features

✔ Automated navigation to LeetCode homepage

✔ Verification of Problemset page

✔ Extraction and display of the first 5 problem titles

✔ Opening and validating the “Two Sum” problem

✔ Checking “Register or Login” message in the submissions tab

✔ Fully executable via gradlew run
---

## 📁 Project Structure

```
NABARUNPAUL02-ME_QA_XLEETCODE1/
│
├── src/main/java/demo/
│   ├── App.java              # Entry point – executes all test cases
│   └── TestCases.java        # Contains TestCase01 to TestCase04
│
├── assesment/                # Crio assessment instruction set
├── build/                    # Auto-generated Gradle build files
├── gradle/                   # Gradle wrapper
│
├── build.gradle              # Project build configuration
├── settings.gradle
│
├── run_assesment.sh          # Generates filtered logs
├── run_platform_assesment.sh  # Runs remote assessment
│
├── assessment_result.json    # Assessment output
├── filtered_logs.json        # Filtered log output for debug
├── chromedriver.log          # ChromeDriver debug logs
│
└── README.md                 # You are here 🚀
```

---

## 🚀 Getting Started

### **1. Prerequisites**

Ensure you have:

* Java 11 or higher
* Chrome Browser
* Gradle (wrapper included)
* Stable internet connection

---

### **2. Run All Test Cases**

```bash
./gradlew run
```

This will:

* Launch Chrome
* Execute testCase01 → testCase04 sequentially
* Print results to the console
* Close the browser

---

### **3. Run Local Assessment (Crio)**

```bash
./run_platform_assesment.sh
```

After execution, results are stored in:

* `assessment_result.json`
* `filtered_logs.json`

---

## 🧪 Implemented Test Cases

### **🔹 TestCase01 — Verify LeetCode Homepage URL**

* Opens **[https://leetcode.com/](https://leetcode.com/)**
* Validates that the current URL contains `"leetcode"`

---

### **🔹 TestCase02 — Validate Problemset Page & Display First 5 Questions**

* Clicks “View Questions”
* Confirms `"problemset"` in URL
* Extracts and prints first 5 problem titles

---

### **🔹 TestCase03 — Validate Two Sum Problem**

* Navigates to the problem with ID `1`
* Checks that the URL contains `"two-sum"`

---

### **🔹 TestCase04 — Check Submissions Tab Login Prompt**

* Opens “Two Sum”
* Clicks on **Submissions**
* Verifies text `"Register or Login"` is visible

---

## 🛠️ Technologies Used

| Technology                | Purpose                     |
| ------------------------- | --------------------------- |
| **Java**                  | Core development language   |
| **Selenium WebDriver**    | Browser automation          |
| **ChromeDriver**          | Chrome automation backend   |
| **WebDriverManager**      | Automatic driver management |
| **Gradle**                | Build & run automation      |

---

## 👨‍💻 Author

**Nabarun Paul**
Test Automation Engineer – TCS
SDET/SDE Aspirant

---

## ⭐ Support

If this project helped you, consider giving it a **⭐ star** on GitHub!

---

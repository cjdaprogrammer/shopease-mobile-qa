# ShopEase Mobile QA Automation

[![Mobile Tests](https://github.com/cjdaprogrammer/shopease-mobile-qa/actions/workflows/mobile-tests.yml/badge.svg)](https://github.com/cjdaprogrammer/shopease-mobile-qa/actions/workflows/mobile-tests.yml)

An Android mobile test automation project for **ShopEase**, demonstrating automated UI testing of login, product listing, shopping cart, and checkout functionality.

The framework uses Appium, Java, TestNG, and Cucumber, with continuous integration through GitHub Actions.

## Project Overview

This project demonstrates an end-to-end Android mobile testing workflow, including:

- Mobile UI test automation
- Page Object Model (POM)
- TestNG test execution
- Cucumber Behavior-Driven Development (BDD)
- Allure test reporting
- Jira and Zephyr Scale test management
- GitHub Actions continuous integration

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Maven | Build and dependency management |
| Appium 3 | Mobile automation |
| UiAutomator2 7.6.2 | Android automation driver |
| Selenium | Automation support |
| TestNG 7.11.0 | Test execution framework |
| Cucumber 7.27.0 | BDD testing |
| Allure 2.29.1 | Test reporting |
| Jira | Test management |
| Zephyr Scale | Test case and cycle management |
| GitHub Actions | CI/CD automation |
| Android 15 (API 35) | Test emulator |

## Application Under Test

**Application:** ShopEase Android App

**Package name:** `com.shopease.app`

**APK location:** `apps/shopease-debug.apk`

**Related repository:**

https://github.com/cjdaprogrammer/ShopEase-Android-App

## Test Coverage

The automation framework covers the following functionalities:

- Login with valid credentials
- Login with invalid credentials
- Product list validation
- Shopping cart functionality
- Cart badge validation
- Cart navigation
- Checkout-related scenarios

### Automated Test Summary

| Test Suite | Test Cases |
|---|---:|
| Login Tests (TestNG) | 6 |
| Cart and Checkout Tests (TestNG) | 7 |
| Cucumber Scenarios | 6 |
| **Total** | **19** |

**Latest local execution result:**

- Tests executed: 19
- Passed: 19
- Failed: 0
- Errors: 0
- Skipped: 0

## Prerequisites

Before running the automation framework, install:

- JDK 17
- Apache Maven
- Node.js
- Android Studio
- Android SDK
- Android SDK Platform Tools
- Android emulator running Android 15
- Appium 3

### Appium Installation

Install Appium:

```bash
npm install -g appium@3
```

Install UiAutomator2:

```bash
appium driver install uiautomator2@7.6.2
```

Make sure `ANDROID_HOME` is configured and `adb` is available in your system PATH.

## Running Tests Locally

1. Open Android Studio.
2. Start your Android emulator.
3. Make sure the ShopEase application is installed.
4. Start the Appium server in a separate terminal:

```bash
appium
```

5. Open a terminal in the project directory.
6. Execute the complete test suite:

```bash
mvn clean test
```

To execute only login tests:

```bash
mvn -Dtest=LoginTest test
```

The complete test suite is configured through `testng.xml`.

## CI/CD – GitHub Actions

This project uses GitHub Actions to automate Android mobile test execution.

### Workflow Process

1. Checks out the QA repository.
2. Sets up Java 17.
3. Sets up Node.js 20.
4. Installs Appium 3 and UiAutomator2.
5. Enables KVM for Android emulator performance.
6. Starts an Android 15 emulator.
7. Starts the Appium server.
8. Executes the configured TestNG and Cucumber test suite.
9. Uploads test reports and execution logs as workflow artifacts.

**Workflow configuration:**

`.github/workflows/mobile-tests.yml`

**GitHub Actions:**

https://github.com/cjdaprogrammer/shopease-mobile-qa/actions

## Allure Test Reports

Allure Reports are used to visualize automated test execution results.

Three reporting views are included in `docs/allure/`:

| Report | Description |
|---|---|
| Report | Overall test execution summary |
| Graph | Visual representation of test results |
| Timeline | Test execution sequence and duration |

**Evidence location:**

`docs/allure/`

To generate and view the report locally:

```bash
allure serve target/allure-results
```

## Jira and Zephyr Scale – Test Management

Jira and Zephyr Scale were used to organize and track test cases and execution results.

### Test Management Evidence

The `docs/jira/` directory contains screenshots documenting:

- 13 created test cases.
- Passed execution status for all 13 test cases.
- Test execution time and duration.
- Screenshots of test case execution results.

**Evidence location:**

`docs/jira/`

## Test Reports and Evidence

| Evidence | Location |
|---|---|
| Allure reports | `docs/allure/` |
| Jira and Zephyr screenshots | `docs/jira/` |
| Surefire reports | `target/surefire-reports/` |
| Cucumber report | `target/cucumber-report.html` |
| Failure screenshots | `screenshots/` |
| Appium logs | `appium.log` |

GitHub Actions also provides downloadable workflow artifacts containing available test reports and logs.

## Known Issues

- `cartBadgeSurvivesBackNavigation` has occasionally been flaky on the emulator and is configured for one automatic retry.
- Each test restarts the application, so a complete local test execution takes approximately five minutes.

## Test Credentials

| Username | Password |
|---|---|
| `standard_user` | `shop123` |

These are demonstration credentials for the ShopEase sample application.

## Project Structure

```text
shopease-mobile-qa/
│
├── .github/
│   └── workflows/
│       └── mobile-tests.yml
│
├── apps/
│   └── shopease-debug.apk
│
├── docs/
│   ├── allure/
│   │   ├── report/
│   │   ├── graph/
│   │   └── timeline/
│   │
│   └── jira/
│       └── test-execution-evidence/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/
│       │   ├── tests/
│       │   ├── stepdefinitions/
│       │   ├── runners/
│       │   └── support/
│       │
│       └── resources/
│           └── features/
│
├── screenshots/
├── testng.xml
├── pom.xml
└── README.md
```

*Folder names above illustrate the intended organization. Keep your actual existing folder and file names.*

## Related Project

**ShopEase Android Application**

https://github.com/cjdaprogrammer/ShopEase-Android-App

## Project Highlights

- Android mobile UI automation using Appium.
- Reusable Page Object Model framework.
- TestNG and Cucumber test execution.
- Allure reporting and test evidence.
- Jira and Zephyr Scale test management.
- GitHub Actions CI pipeline with Android emulator execution.

---

**ShopEase Mobile QA Automation**

Android Mobile Testing | Test Automation | Test Management | CI/CD
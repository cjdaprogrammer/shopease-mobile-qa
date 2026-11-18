# ShopEase Mobile QA Automation

Automated UI tests for the ShopEase Android app (login, product list, cart, checkout).

## Tech stack
- Java 17, Maven
- Appium 3 with the UiAutomator2 driver
- TestNG and Cucumber (BDD)
- Android 15 (API 35) emulator

## Prerequisites
- Android Studio with the SDK, platform-tools and an emulator named `ShopEase_Pixel8`
- Node.js and Appium: `npm install -g appium` then `appium driver install uiautomator2@7.6.2`
- The ShopEase app installed on the emulator (package `com.shopease.app`)
- `ANDROID_HOME` set and `adb` on your PATH

## Run the tests
1. Start the emulator.
2. Start Appium in a separate window: `appium`
3. Run: `mvn test`

Reports: `target/cucumber-report.html` and `target/surefire-reports`.
Screenshots of failures are saved to `screenshots/`.

## Test credentials
`standard_user` / `shop123`

## Project structure
- `src/test/java/pages` – page objects
- `src/test/java/tests` – TestNG tests
- `src/test/java/stepdefinitions` – Cucumber steps and hooks
- `src/test/java/runners` – Cucumber runner
- `src/test/resources/features` – Gherkin feature files
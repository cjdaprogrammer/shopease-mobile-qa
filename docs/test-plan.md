# ShopEase Mobile Test Plan

## 1. Scope
Functional, negative and regression testing of the ShopEase Android app:
login, product list, cart and checkout.

## 2. Out of scope
Performance, security, accessibility, real payment processing, multiple
screen sizes, real devices.

## 3. Test environment
- Android 15 (API 35) emulator, Pixel 8 profile
- Appium 3 with the UiAutomator2 driver
- Java 17, Maven, TestNG, Cucumber, Allure
- Test account: standard_user / shop123

## 4. Approach
- UI automation using the Page Object Model
- Explicit waits, screenshot capture on failure
- Each test starts from a clean app state
- Reports: Allure and Cucumber HTML

## 5. Entry and exit criteria
- Entry: app builds and installs, emulator and Appium running
- Exit: all planned tests executed, no open critical defects

## 6. Risks
- Emulator timing issues cause flaky tests (mitigated with waits and one rerun)
- App is a small purpose-built test app, so coverage does not represent a
  full production shop
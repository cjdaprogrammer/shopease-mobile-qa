package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws Exception {

        if (driver == null) {

            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setUdid(System.getProperty("udid", "emulator-5554"));

            String apk = System.getProperty("apk");
            if (apk != null) {
                options.setApp(apk);
            } else {
                options.setAppPackage(System.getProperty("appPackage", "com.shopease.app"));
                options.setAppActivity(System.getProperty("appActivity", ".MainActivity"));
            }

            options.setNoReset(false);
            options.setCapability("appium:disableWindowAnimation", true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static AndroidDriver peekDriver() {
        return driver;
    }   
}
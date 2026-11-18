
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import io.appium.java_client.android.AndroidDriver;
import support.DriverFactory;

public class ShopEaseLaunchTest {

    private AndroidDriver driver;

    @Test
    public void verifySettingsAppLaunch() throws Exception {

        driver = DriverFactory.getDriver();

        Assert.assertNotNull(
                driver.getSessionId(),
                "Appium session should be created"
        );

        Assert.assertTrue(
                driver.getSessionId().toString().length() > 0
        );
        Assert.assertEquals(driver.getCurrentPackage(), "com.shopease.app",
        "ShopEase should be the foreground app");

        System.out.println("Android Settings launched!");
        System.out.println("Session ID: " + driver.getSessionId());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

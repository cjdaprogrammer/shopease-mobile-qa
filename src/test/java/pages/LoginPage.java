package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) { this.driver = driver; }

    public void login(String user, String pass) {
        driver.findElement(AppiumBy.id("com.shopease.app:id/usernameInput")).sendKeys(user);
        driver.findElement(AppiumBy.id("com.shopease.app:id/passwordInput")).sendKeys(pass);
        driver.findElement(AppiumBy.id("com.shopease.app:id/loginButton")).click();
    }

    public String getError() {
        return driver.findElement(AppiumBy.id("com.shopease.app:id/errorMessage")).getText();
    }
}
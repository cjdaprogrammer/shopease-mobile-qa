package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) { this.driver = driver; }

    private WebElement waitFor(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.shopease.app:id/" + id)));
    }

    public void login(String user, String pass) {
        WebElement usernameField = waitFor("usernameInput");
        if (!user.isEmpty()) {
            usernameField.sendKeys(user);
        }
        if (!pass.isEmpty()) {
            driver.findElement(AppiumBy.id("com.shopease.app:id/passwordInput")).sendKeys(pass);
        }
        driver.findElement(AppiumBy.id("com.shopease.app:id/loginButton")).click();
    }

    public String getError() {
        return waitFor("errorMessage").getText();
    }
}
package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final AndroidDriver driver;

    public CartPage(AndroidDriver driver) { this.driver = driver; }

    private WebElement waitFor(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.shopease.app:id/" + id)));
    }

    public String getCartCount() {
        return waitFor("cartCount").getText();
    }

    public void checkout() {
        waitFor("checkoutButton").click();
    }

    public String getConfirmation() {
        return waitFor("orderConfirmation").getText();
    }
}
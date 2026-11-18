package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage {
    private final AndroidDriver driver;

    public ProductListPage(AndroidDriver driver) { this.driver = driver; }

    private WebElement waitFor(String id) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("com.shopease.app:id/" + id)));
    }

    public boolean isDisplayed() {
        return waitFor("productsTitle").isDisplayed();
    }

    public void addToCart(int productNumber) {
        waitFor("addToCartButton" + productNumber).click();
    }

    public String getCartBadge() {
        return waitFor("cartBadge").getText();
    }

    public void openCart() {
        waitFor("viewCartButton").click();
    }
}
package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {
    private final AndroidDriver driver;

    public CartPage(AndroidDriver driver) { this.driver = driver; }

    public String getCartCount() {
        return driver.findElement(AppiumBy.id("com.shopease.app:id/cartCount")).getText();
    }

    public void checkout() {
        driver.findElement(AppiumBy.id("com.shopease.app:id/checkoutButton")).click();
    }

    public String getConfirmation() {
        return driver.findElement(AppiumBy.id("com.shopease.app:id/orderConfirmation")).getText();
    }
}
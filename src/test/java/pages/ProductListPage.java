package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductListPage {
    private final AndroidDriver driver;

    public ProductListPage(AndroidDriver driver) { this.driver = driver; }

    public boolean isDisplayed() {
        return driver.findElement(AppiumBy.id("com.shopease.app:id/productsTitle")).isDisplayed();
    }

    public void addToCart(int productNumber) {
        driver.findElement(AppiumBy.id("com.shopease.app:id/addToCartButton" + productNumber)).click();
    }

    public String getCartBadge() {
        return driver.findElement(AppiumBy.id("com.shopease.app:id/cartBadge")).getText();
    }

    public void openCart() {
        driver.findElement(AppiumBy.id("com.shopease.app:id/viewCartButton")).click();
    }
}
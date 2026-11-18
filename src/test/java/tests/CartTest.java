package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class CartTest extends BaseTest {

    private ProductListPage products;

    @BeforeMethod
    public void login() {
        new LoginPage(driver).login("standard_user", "shop123");
        products = new ProductListPage(driver);
    }

    @Test
    public void addingProductUpdatesBadge() {
        products.addToCart(1);
        Assert.assertEquals(products.getCartBadge(), "Cart: 1");
    }

    @Test
    public void cartShowsAddedItems() {
        products.addToCart(1);
        products.addToCart(2);
        products.openCart();
        Assert.assertEquals(new CartPage(driver).getCartCount(), "Items in cart: 2");
    }

    @Test
    public void checkoutWithItemsPlacesOrder() {
        products.addToCart(3);
        products.openCart();
        CartPage cart = new CartPage(driver);
        cart.checkout();
        Assert.assertEquals(cart.getConfirmation(), "Order placed");
    }

    @Test
    public void checkoutWithEmptyCartIsBlocked() {
        products.openCart();
        CartPage cart = new CartPage(driver);
        cart.checkout();
        Assert.assertEquals(cart.getConfirmation(), "Cart is empty");
    }

    @Test
    public void sameProductAddedTwiceCountsTwice() {
        products.addToCart(1);
        products.addToCart(1);
        Assert.assertEquals(products.getCartBadge(), "Cart: 2");
    }

    @Test
    public void allThreeProductsCanBeAdded() {
        products.addToCart(1);
        products.addToCart(2);
        products.addToCart(3);
        products.openCart();
        Assert.assertEquals(new CartPage(driver).getCartCount(), "Items in cart: 3");
    }

    @Test
    public void cartBadgeSurvivesBackNavigation() {
        products.addToCart(2);
        products.openCart();
        driver.navigate().back();
        Assert.assertTrue(products.isDisplayed(),
                "Back should return to Products, but the current activity is: "
                        + driver.currentActivity());
        Assert.assertEquals(products.getCartBadge(), "Cart: 1");
}
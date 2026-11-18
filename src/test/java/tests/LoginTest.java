package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductListPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShowsProducts() {
        new LoginPage(driver).login("standard_user", "shop123");
        Assert.assertTrue(new ProductListPage(driver).isDisplayed());
    }

    @Test
    public void invalidLoginShowsError() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong");
        Assert.assertEquals(login.getError(), "Invalid username or password");
    }
}
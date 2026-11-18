package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;
import support.DriverFactory;

public class CartSteps {

    @Given("the user is logged in as {string} with password {string}")
    public void userIsLoggedIn(String user, String pass) throws Exception {
        new LoginPage(DriverFactory.getDriver()).login(user, pass);
    }

    @When("the user adds product {int} to the cart")
    public void userAddsProduct(int number) throws Exception {
        new ProductListPage(DriverFactory.getDriver()).addToCart(number);
    }

    @When("the user opens the cart")
    public void userOpensCart() throws Exception {
        new ProductListPage(DriverFactory.getDriver()).openCart();
    }

    @When("the user checks out")
    public void userChecksOut() throws Exception {
        new CartPage(DriverFactory.getDriver()).checkout();
    }

    @Then("the cart badge shows {string}")
    public void cartBadgeShows(String expected) throws Exception {
        Assert.assertEquals(new ProductListPage(DriverFactory.getDriver()).getCartBadge(), expected);
    }

    @Then("the cart shows {string}")
    public void cartShows(String expected) throws Exception {
        Assert.assertEquals(new CartPage(DriverFactory.getDriver()).getCartCount(), expected);
    }

    @Then("the order confirmation shows {string}")
    public void orderConfirmationShows(String expected) throws Exception {
        Assert.assertEquals(new CartPage(DriverFactory.getDriver()).getConfirmation(), expected);
    }
}
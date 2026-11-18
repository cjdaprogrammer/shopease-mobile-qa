package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductListPage;
import support.DriverFactory;

public class LoginSteps {

    @Given("the user is on the login screen")
    public void userIsOnLoginScreen() throws Exception {
        DriverFactory.getDriver();
    }

    @When("the user logs in with {string} and {string}")
    public void userLogsIn(String user, String pass) throws Exception {
        new LoginPage(DriverFactory.getDriver()).login(user, pass);
    }

    @Then("the products screen is displayed")
    public void productsScreenDisplayed() throws Exception {
        Assert.assertTrue(new ProductListPage(DriverFactory.getDriver()).isDisplayed());
    }

    @Then("the error {string} is shown")
    public void errorIsShown(String message) throws Exception {
        Assert.assertEquals(new LoginPage(DriverFactory.getDriver()).getError(), message);
    }
}
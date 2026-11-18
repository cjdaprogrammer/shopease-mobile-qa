package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import support.DriverFactory;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            byte[] png = DriverFactory.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(png, "image/png", "failure");
        }
        DriverFactory.quitDriver();
    }
}
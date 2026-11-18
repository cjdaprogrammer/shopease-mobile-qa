package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import support.DriverFactory;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        AndroidDriver driver = DriverFactory.peekDriver();
        if (driver != null && scenario.isFailed()) {
            byte[] png = driver.getScreenshotAs(OutputType.BYTES);
            scenario.attach(png, "image/png", "failure");
        }
        DriverFactory.quitDriver();
    }
}
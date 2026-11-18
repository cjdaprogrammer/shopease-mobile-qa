package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import support.DriverFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            Path dir = Path.of("screenshots");
            Files.createDirectories(dir);
            Files.copy(
                driver.getScreenshotAs(OutputType.FILE).toPath(),
                dir.resolve(result.getName() + ".png"),
                StandardCopyOption.REPLACE_EXISTING);
        }
        DriverFactory.quitDriver();
    }
}
package support;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("START: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAIL: " + result.getName());
        try {
            AndroidDriver driver = DriverFactory.peekDriver();
            if (driver == null) {
                return;
            }
            byte[] png = driver.getScreenshotAs(OutputType.BYTES);

            Path dir = Path.of("screenshots");
            Files.createDirectories(dir);
            Files.write(dir.resolve(result.getName() + ".png"), png);

            Allure.addAttachment("Failure screenshot", "image/png",
                    new ByteArrayInputStream(png), "png");
        } catch (Exception e) {
            System.out.println("Could not capture screenshot: " + e.getMessage());
        }
    }
}
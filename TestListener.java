package Listeners;

import org.testng.*;
import org.openqa.selenium.*;
import java.io.File;

import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.*;
import utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");

        System.out.println("TEST PASSED: " + result.getName());
    }
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = ((tests.BaseTest) testClass).driver;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

            FileUtils.copyFile(src, new File(path));

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
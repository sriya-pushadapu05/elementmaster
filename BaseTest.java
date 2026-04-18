package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import base.DriverFactory;
import config.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }
    public void openPage(String path) {
        driver.get(ConfigReader.get("baseUrl") + path);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
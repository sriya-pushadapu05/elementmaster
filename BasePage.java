package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import config.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout"))));
    }

    // CLICK with full wait
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    // TYPE with wait
    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(text);
    }

    // GET TEXT with wait
    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // WAIT FOR ALERT
    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // SWITCH TO FRAME
    public void switchToFrame(By locator) {
        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.switchTo().frame(frame);
    }

    // SWITCH BACK
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    By simple = By.id("alertButton");
    By confirm = By.id("confirmButton");
    By prompt = By.id("promptButton");

    public void handleSimpleAlert() {
        click(simple);
        waitForAlert().accept();
    }

    public void handleConfirmAlert() {
        click(confirm);
        waitForAlert().dismiss();
    }

    public void handlePromptAlert() {
        click(prompt);
        Alert alert = waitForAlert();
        alert.sendKeys("Hello");
        alert.accept();
    }
}
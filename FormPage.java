package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    By nameField = By.id("userName");
    By emailField = By.id("userEmail");
    By submitBtn = By.id("submit");

    public void fillForm(String name, String email) {
        type(nameField, name);
        type(emailField, email);
    }

    public void submitForm() {
        click(submitBtn);
    }
}
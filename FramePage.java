package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    By frame = By.id("frame1");

    public void switchToFrame() {
        switchToFrame(frame);  
        System.out.println("Switched to frame");
        switchToDefault();    
    }
}
package tests;

import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testAlert() {

    	openPage("/alerts"); 
        AlertPage page = new AlertPage(driver);

        page.handleSimpleAlert();
        page.handleConfirmAlert();
        page.handlePromptAlert();
    }
}
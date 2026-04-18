package tests;

import org.testng.annotations.Test;
import pages.WidgetPage;

public class WidgetTest extends BaseTest {

    @Test
    public void testWidget() {

        WidgetPage page = new WidgetPage(driver);

        openPage("/date-picker");
        page.selectDate();

        openPage("/slider");
        page.moveSlider();

        openPage("/accordian");
        page.clickAccordion();
    }
}
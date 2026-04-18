package tests;

import org.testng.annotations.Test;
import pages.WebTablePage;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable() {

        openPage("/webtables");   

        WebTablePage page = new WebTablePage(driver);

        page.addRecord();
        page.searchRecord();
        page.deleteRecord();
    }
}
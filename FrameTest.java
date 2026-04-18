package tests;
	import org.testng.annotations.Test;
	import pages.FramePage;

	public class FrameTest extends BaseTest {

	    @Test
	    public void testFrame() {

	    	openPage("/frames"); 

	        FramePage page = new FramePage(driver);
	        page.switchToFrame();
	    }
	}



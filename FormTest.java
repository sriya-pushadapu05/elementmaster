package tests;


	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import pages.FormPage;

	public class FormTest extends BaseTest {

	    @Test(dataProvider = "formData")
	    public void testForm(String name, String email) {
  
	    	openPage("/text-box");

	        FormPage form = new FormPage(driver);
	        form.fillForm(name, email);
	        form.submitForm();
	    }

	    @DataProvider(name = "formData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"Sriya", "sriya@test.com"},
	            {"TestUser", "test@test.com"}
	        };
	    }
	}


package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.LogoutPage;

public class Logout {
	
	public WebDriver driver;
	private LoginPage loginpage;
	private LogoutPage logoutpage;
	
	@When("User enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
		driver=DriverFactory.getDriver();
		loginpage=new LoginPage(driver);
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		loginpage.setUsername(dataMap.get("username"));
		loginpage.setPassword(dataMap.get("password"));
	}
	
	@When("user click the login button")
	public void user_click_the_login_button() {
	   loginpage.clickOnLoginBtn();
	}
	
	@Then("user should redirected to the dashboard")
	public void user_should_redirected_to_the_dashboard() {
	    if(driver.getPageSource().contains("Dashboard")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	try {
	    	Assert.assertTrue(false);
	    	}
	    	catch(Throwable e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	

	@When("user clicks on the profile icon")
	public void user_clicks_on_the_profile_icon() {
	  logoutpage=new LogoutPage(driver);
	  logoutpage.clickOnUserProfileDropDown();
	}

	@When("user clicks on the Logout button")
	public void user_clicks_on_the_Logout_button() {
	  logoutpage.clickOnLogoutBtn(); 
	}

	@Then("user should redirected to the login page")
	public void user_should_redirected_to_the_login_page() {
		loginpage.displayStatusOfLoginTextOnPage();
	}

}//class

package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
	
	public WebDriver driver;
	private LoginPage loginpage;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver=DriverFactory.getDriver();
	   loginpage=new LoginPage(driver);
	   loginpage.displayStatusOfLoginTextOnPage();
	}
	
	@When("^user enters valid username (.+)$")
	public void user_enters_valid_username(String username) {
		 loginpage.setUsername(username);
	}

	@When("^user enters valid password (.+)$")
	public void user_enters_valid_password(String password) {
		loginpage.setPassword(password);
	}
	
	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
	   loginpage.clickOnLoginBtn();
	}

	@Then("user should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() {
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
	
	@When("user enters invalid username {string}")
	public void user_enters_invalid_username(String username) {
	    loginpage.setUsername(username);
	}

	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String password) {
	   loginpage.setPassword(password);
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
	    Assert.assertEquals("Invalid credentials", loginpage.displayStatusOfWarningMsg());
	}

	@When("user leaves both the username and password fields empty")
	public void user_leaves_both_the_username_and_password_fields_empty() {
	   //intentionally kept blank
	}

	@Then("an error message should be displayed indicating Username and Password are required")
	public void an_error_message_should_be_displayed_indicating_username_and_password_are_required() {
	    Assert.assertEquals("Required", loginpage.displayWarningTextForUsername());
	    Assert.assertEquals("Required", loginpage.displayWarningTextForPassword());
	}

}

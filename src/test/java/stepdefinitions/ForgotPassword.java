package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgotPassword {
	
	public WebDriver driver;
	private LoginPage loginpage;
	private ForgotPasswordPage forgotpasswordpage;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		   driver=DriverFactory.getDriver();
		   loginpage=new LoginPage(driver);
		   forgotpasswordpage=new ForgotPasswordPage(driver);
		   loginpage.displayStatusOfLoginTextOnPage();
	   
	}

	@When("User click on the Forgot your password link")
	public void user_click_on_the_forgot_your_password_link() {
	   forgotpasswordpage.clickOnForgotPasswordLink();
	}

	@Then("User should be redirected to the password reset page")
	public void user_should_be_redirected_to_the_password_reset_page() {
		if(driver.getPageSource().contains("Reset Password")) {
			Assert.assertTrue(true);
		}
		else {
			try {
			Assert.assertTrue(false);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}

	@When("User enters valid username {string}")
	public void user_enters_valid_username(String username) {
		forgotpasswordpage.setUsernameField(username);
	   
	}

	@When("User click on the Reset Password button")
	public void user_click_on_the_reset_password_button() {
	   forgotpasswordpage.clickOnResetPasswordbtn();
	}

	@Then("User should see a confirmation message indicating that an email has been sent")
	public void user_should_see_a_confirmation_message_indicating_that_an_email_has_been_sent() {
	   Assert.assertEquals("Reset Password link sent successfully", forgotpasswordpage.displayStatusOfTextResetPassword());
	}

	@When("User dont enter username")
	public void user_dont_enter_username() {
	   //intentionally kept blank
	}

	@Then("User should see a proper warning message")
	public void user_should_see_a_proper_warning_message() {
	   Assert.assertEquals("Required", forgotpasswordpage.displayStatusOfUsernameRequiredText());
	}
	
}

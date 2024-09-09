package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangePasswordPage;

public class ChangePassword {
	
	public WebDriver driver;
	private ChangePasswordPage changePasswordPage;
	
	@When("User clicks on UserProfile")
	public void user_clicks_on_user_profile() {
		driver=DriverFactory.getDriver();
		changePasswordPage=new ChangePasswordPage(driver);
		changePasswordPage.clickOnUserProfile();
	}
	@When("User clicks on Change Password link")
	public void user_clicks_on_change_password_link() {
	  changePasswordPage.clickOnChangePasswordLink(); 
	}
	@Then("User should see Update Password page")
	public void user_should_see_update_password_page() {
	   Assert.assertEquals(changePasswordPage.getTextUpdatePassword(), "Update Password");
	}
	@When("User enters Current Password {string}")
	public void user_enters_current_password(String currentPassword) {
	  changePasswordPage.setCurrentPassword(currentPassword);
	}
	@When("User enters Password {string}")
	public void user_enters_password(String password) {
	  changePasswordPage.setPassword(password);
	}
	@When("User enters Confirm Password {string}")
	public void user_enters_confirm_password(String confirmPassword) {
	  changePasswordPage.setConfirmPassword(confirmPassword);
	}

	@When("User clicks on Save Button")
	public void user_clicks_on_save_button() {
	   changePasswordPage.clickOnSaveBtnUpdatePasswordPage();
	}

}//class

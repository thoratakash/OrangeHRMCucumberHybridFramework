package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class ChangePasswordPage {
	
	public WebDriver driver;
	private ElementUtils elementUtils;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']/child::p")
	@CacheLookup
	WebElement linkUserProfile;
	
	@FindBy(xpath = "//a[text()='Change Password']")
	@CacheLookup
	WebElement linkChangePassword;
	
	@FindBy(xpath = "//div[@class='orangehrm-card-container']/child::h6[text()='Update Password']")
	@CacheLookup
	WebElement textUpdatePassword;
	
	@FindBy(xpath = "//label[text()='Current Password']/following::input[1]")
	@CacheLookup
	WebElement txtCurrentPassword;
	
	@FindBy(xpath = "//label[text()='Password']/following::input[1]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnSaveOnUpdatePasswordPage;
	
	public void clickOnUserProfile() {
		elementUtils.ClickByUsingActionsClass(linkUserProfile, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnChangePasswordLink() {
		elementUtils.ClickByUsingActionsClass(linkChangePassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String getTextUpdatePassword() {
		return elementUtils.getTextFromElement(textUpdatePassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setCurrentPassword(String currentPassword) {
		elementUtils.clearTextFieldUsingActionsClass(txtCurrentPassword, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtCurrentPassword, currentPassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setPassword(String password) {
		elementUtils.clearTextFieldUsingActionsClass(txtPassword, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtPassword, password, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		elementUtils.clearTextFieldUsingActionsClass(txtConfirmPassword, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtConfirmPassword, confirmPassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnSaveBtnUpdatePasswordPage() {
		elementUtils.ClickByUsingActionsClass(btnSaveOnUpdatePasswordPage, DriverFactory.EXPLICIT_TIMEOUT);
	}

}//class

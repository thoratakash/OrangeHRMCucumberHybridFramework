package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class ForgotPasswordPage {
	
	public WebDriver driver; 
	private ElementUtils elementUtils;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']//p")
	@CacheLookup
	WebElement lnkForgotPassword;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnResetPassword;
	
	@FindBy(xpath = "//div[@class='orangehrm-card-container']//h6")
	@CacheLookup
	WebElement txtResetPasswordPage;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	@CacheLookup
	WebElement txtUsernameRequired;
	
	public void clickOnForgotPasswordLink() {
		elementUtils.clickOnElement(lnkForgotPassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setUsernameField(String username) {
		elementUtils.typeTextIntoField(txtUsername, username, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnResetPasswordbtn() {
		elementUtils.clickOnElement(btnResetPassword, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String displayStatusOfTextResetPassword() {
		return elementUtils.getTextFromElement(txtResetPasswordPage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String displayStatusOfUsernameRequiredText() {
		return elementUtils.getTextFromElement(txtUsernameRequired, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
}//class

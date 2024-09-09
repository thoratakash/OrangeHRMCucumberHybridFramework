package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class LoginPage {
	
	public WebDriver driver;
	private ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 elementUtils=new ElementUtils(driver);
	}
	
	//Login Text
	@FindBy(xpath = "//h5[text()='Login']")
	@CacheLookup
	WebElement txtLoginOnPage;
	
	@FindBy(name = "username")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = " //button[contains(@type,'submit')]")
	@CacheLookup
	WebElement btnLogin;
	
	//Invalid Credentails Text
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	@CacheLookup
	WebElement txtInvalidCredential;
	
	@FindBy(xpath = "(//span[text()='Required'])[last()-1]")
	@CacheLookup
	WebElement txtRequiredUsername;
	
	@FindBy(xpath = "(//span[text()='Required'])[last()]")
	@CacheLookup
	WebElement txtRequiredPassword;
	
	

	public void setUsername(String username) {
		elementUtils.typeTextIntoField(txtUsername, username, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setPassword(String password) {
		elementUtils.typeTextIntoField(txtPassword, password, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnLoginBtn() {
		elementUtils.clickOnElement(btnLogin, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void displayStatusOfLoginTextOnPage() {
		elementUtils.isDisplayOfElement(txtLoginOnPage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String displayStatusOfWarningMsg() {
		return elementUtils.getTextFromElement(txtInvalidCredential, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String displayWarningTextForUsername() {
		return elementUtils.getTextFromElement(txtRequiredUsername, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
   public String displayWarningTextForPassword() {
	   return elementUtils.getTextFromElement(txtRequiredPassword, DriverFactory.EXPLICIT_TIMEOUT);		
	}
	

}//class

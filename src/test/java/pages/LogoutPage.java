package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class LogoutPage {
	
	public WebDriver driver;
	private ElementUtils elementUtils;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	@CacheLookup
	WebElement drpDwnUserProfile;
	
	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	@CacheLookup
	WebElement btnLogout;
	
	public void clickOnUserProfileDropDown() {
		elementUtils.clickOnElement(drpDwnUserProfile, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnLogoutBtn() {
		elementUtils.clickOnElement(btnLogout, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	
	
	

}//class

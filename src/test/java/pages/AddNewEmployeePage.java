package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class AddNewEmployeePage {

	public WebDriver driver;
	private ElementUtils elementUtils;

	public AddNewEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
	@CacheLookup
	WebElement linkPIM;

	@FindBy(xpath = "//a[text()='Add Employee']")
	@CacheLookup
	WebElement linkAddEmployee;

	@FindBy(name = "firstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(name = "middleName")
	@CacheLookup
	WebElement txtMiddleName;

	@FindBy(name = "lastName")
	@CacheLookup
	WebElement txtLastName;

	// @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	@FindBy(xpath = "//label[@class=\"oxd-label\"]/following::input[1]")
	@CacheLookup
	WebElement txtEmployeeID;

	@FindBy(xpath = "//input[@type='checkbox']/following::span[1]")
	@CacheLookup
	WebElement checkBoxCreateLogin;

	@FindBy(xpath = "//label[text()='Username']/following::input[1]")
	@CacheLookup
	WebElement txtUsernameForLogin;

	@FindBy(xpath = "//label[text()='Password']/following::input[1]")
	@CacheLookup
	WebElement txtPasswordForLogin;

	@FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
	@CacheLookup
	WebElement txtConfirmPasswordForLogin;

	@FindBy(xpath = "//input[@type='checkbox']/following::span[2]")
	@CacheLookup
	WebElement radStatusEnabled;

	@FindBy(xpath = "//input[@type='checkbox']/following::span[3]")
	@CacheLookup
	WebElement radStatusDisabled;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnSave;

	@FindBy(xpath = "//h6[text()='Personal Details']")
	@CacheLookup
	WebElement textPersonalDetail;

	@FindBy(xpath = "//span[text()='Username already exists']")
	@CacheLookup
	WebElement textUsernameAlreadyExists;
	
	
	@FindBy(xpath = "//span[text()='Employee Id already exists']")
	@CacheLookup
	WebElement textEmployeeIDAlreadyExists;

	public void clickOnPIMLink() {
		elementUtils.clickOnElement(linkPIM, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnAddEmployeeLink() {
		elementUtils.clickOnElement(linkAddEmployee, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setFirstNameField(String FirstName) {
		elementUtils.typeTextIntoField(txtFirstName, FirstName, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setMiddleNameField(String MiddleName) {
		elementUtils.typeTextIntoField(txtMiddleName, MiddleName, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setLastNameField(String LastName) {
		elementUtils.typeTextIntoField(txtLastName, LastName, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setEmployeeID(String EmployeeID) {
		elementUtils.clearTextFieldUsingActionsClass(txtEmployeeID, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtEmployeeID, EmployeeID, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnCreateLoginCheckBox() {
		elementUtils.clickOnElement(checkBoxCreateLogin, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setUsernameForLogin(String Username) {
		elementUtils.typeTextIntoField(txtUsernameForLogin, Username, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setPasswordForLogin(String Password) {
		elementUtils.typeTextIntoField(txtPasswordForLogin, Password, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setConfirmPasswordForLogin(String ConfirmPassword) {
		elementUtils.typeTextIntoField(txtConfirmPasswordForLogin, ConfirmPassword, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void selectRadioButton() {
		elementUtils.selectRadioButtonOfElement(radStatusEnabled, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnSaveBtn() {
		elementUtils.clickOnElement(btnSave, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public String displayStatusOfProfileNameText() {
		return elementUtils.getTextFromElement(textPersonalDetail, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public String displayStatusOfEmployeeIDAlreadyExist() {
		return elementUtils.getTextFromElement(textEmployeeIDAlreadyExists, DriverFactory.EXPLICIT_TIMEOUT);
	}

}// class

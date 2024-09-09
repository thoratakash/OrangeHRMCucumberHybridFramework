package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class EditEmployeeDetailsPage {

	public WebDriver driver;
	private ElementUtils elementUtils;

	public EditEmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[text()='Employee List']")
	@CacheLookup
	private WebElement lnkEmployeeList;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[last()-1]")
	@CacheLookup
	private WebElement txtEmployeeName;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	@CacheLookup
	private WebElement txtEmployeeID;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement btnSearchEmployeeInfoPage;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div[1]/div[2]")
	@CacheLookup
	private List<WebElement> tableRecordID;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div[1]/div[1]")
	@CacheLookup
	private List<WebElement> tableCheckBox;

	@FindBy(xpath = "//input[@name=\"lastName\"]")
	@CacheLookup
	private WebElement txtLastName;

	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[last()]")
	@CacheLookup
	private WebElement txtdateOfBirth;

	@FindBy(xpath = "//div[@class='oxd-date-input-calendar']//div[text()='Close']")
	@CacheLookup
	private WebElement drpDownCloseBtn;

	@FindBy(xpath = "//div[@class='--gender-grouped-field']//div[@class=\"oxd-radio-wrapper\"]")
	@CacheLookup
	private List<WebElement> radGender;

	@FindBy(xpath = "(//button[@type='submit'])[last()-1]")
	@CacheLookup
	private WebElement btnSavePersonalDetailsPage;

	@FindBy(xpath = "//a[text()='Job']")
	@CacheLookup
	private WebElement lnkJob;

	@FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
	@CacheLookup
	private WebElement txtJoinedDate;

	@FindBy(xpath = "//div[text()='Close']")
	@CacheLookup
	private WebElement drpDwnCloseBtnOfJobPage;

	@FindBy(xpath = "//label[text()='Job Title']/following::div[1]")
	@CacheLookup
	private WebElement drpdwnJobTitle;

	@FindBy(xpath = "//label[text()='Location']/following::div[1]")
	@CacheLookup
	private WebElement drpdwnLocation;

	@FindBy(xpath = "//label[text()='Employment Status']/following::div[1]")
	@CacheLookup
	private WebElement drpdwnEmploymentStatus;

	// common for all DropDown options
	@FindBy(xpath = "//div[@role='option']")
	@CacheLookup
	private List<WebElement> drpdwnOptions;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement btnSaveJobPage;
	
	@FindBy(xpath = "//label[text()='Job Category']/following::div[1]")
	@CacheLookup
	private WebElement drpdwnJobCategory;

	@FindBy(xpath = "//div[@role='listbox']//div")
	@CacheLookup
	private List<WebElement> drpdwnOpt;

	@FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']")
	@CacheLookup
	private List<WebElement> totalRecordFounds;
		
	//Delete employee from records
	
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']/following::i[@class='oxd-icon bi-trash']")
	@CacheLookup
	private WebElement btnTrash;
		
	@FindBy(xpath = "//*[@class='orangehrm-modal-footer']/child::button[2]")
	@CacheLookup
	private WebElement btnConfirmDelete;
	
	public void clickOnEmployeeListLink() {
		elementUtils.clickOnElement(lnkEmployeeList, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setEmployeeIDField(String employeeID) {
		elementUtils.waitForVisibilityOfElement(txtEmployeeID, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(txtEmployeeID, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtEmployeeID, employeeID, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnSearchBtnOfEmpInfoPage() {
		elementUtils.waitForVisibilityOfElement(btnSearchEmployeeInfoPage, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(btnSearchEmployeeInfoPage, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnRecordFoundCell() {

		System.out.println("Total Records Found : " + totalRecordFounds.size());

		for (WebElement records : totalRecordFounds) {
			String record = elementUtils.getTextFromElement(records, DriverFactory.EXPLICIT_TIMEOUT);
			if (record.contains("786358")) {
				records.click();
				break;
			}
		}
	}

	public void setLastNameField(String lastname) {
		elementUtils.waitForVisibilityOfElement(txtLastName, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(txtLastName, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtLastName, lastname, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setDateOfBirth(String dob) {
		elementUtils.waitForVisibilityOfElement(txtdateOfBirth, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(txtdateOfBirth, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtdateOfBirth, dob, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void selectGender() {

		for (WebElement gender : radGender) {
			if (gender.getText().contains("Male")) {
				gender.click();
			} else {
				gender.click();
			}
			break;
		}
	}

	public void clickOnSaveBtnOfPersonalDetailsPage() {
		elementUtils.waitForVisibilityOfElement(btnSavePersonalDetailsPage, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(btnSavePersonalDetailsPage, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnJobTap() {
		elementUtils.waitForVisibilityOfElement(lnkJob, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(lnkJob, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setJoinedDateOfJob(String joiningDate) {
		elementUtils.waitForVisibilityOfElement(txtJoinedDate, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(txtJoinedDate, DriverFactory.EXPLICIT_TIMEOUT);	
		elementUtils.typeTextIntoField(txtJoinedDate, joiningDate, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void setJobCategory(String jobcategory) {
		elementUtils.waitForVisibilityOfElement(drpdwnJobCategory, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(drpdwnJobCategory, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.selectOptionFromDropDown(drpdwnOpt, jobcategory, DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickSaveBtnOnJobPage() {
		elementUtils.waitForVisibilityOfElement(btnSaveJobPage, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(btnSaveJobPage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	//Delete Employee from Records
	public void clickOnTrashButton() {
		elementUtils.waitForVisibilityOfElement(btnTrash, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(btnTrash, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(btnConfirmDelete, DriverFactory.EXPLICIT_TIMEOUT);
	}

}// class

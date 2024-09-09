package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utils.ElementUtils;

public class LeaveManagementPage {
	
	public WebDriver driver;
	private ElementUtils elementUtils;

	public LeaveManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	// Leave Request WebElements
	
	@FindBy(xpath = "//span[text()='Leave']")
	@CacheLookup
	private WebElement lnkLeave;
	
	@FindBy(xpath = "//a[text()='Apply']")
	@CacheLookup
	private WebElement tapApplyLink;
	
	@FindBy(xpath = "//h6[text()='Apply Leave']")
	@CacheLookup
	private WebElement textApplyLeave;
	
	@FindBy(xpath = "//label[text()='Leave Type']/following::div[@class='oxd-select-wrapper']")
	@CacheLookup
	private WebElement drpdwnLeaveType;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[last()-1]")
	@CacheLookup
	private WebElement drpdwnFromDate;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[last()]")
	@CacheLookup
	private WebElement drpdwnToDate;
	
	@FindBy(xpath = "//label[text()='Comments']/following::div/child::textarea")
	@CacheLookup
	private WebElement txtComments;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement btnApplyOnLeavePage;
	
	@FindBy(xpath = "//div[@role='listbox']/child::div[@role='option']")
	@CacheLookup
	private List<WebElement> drpdwnLeaveTypeOption;
	
	
    // Cancel Leave Request WebElements
	
	//@FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']/child::a[contains(text(),'Leave List')]")
	@FindBy(xpath = "//a[text()='Leave List']")
	@CacheLookup
	private WebElement lnkLeaveListTap;
	
	@FindBy(xpath = "//h5[text()='Leave List']")
	@CacheLookup
	private WebElement textLeaveList;
	
	@FindBy(xpath = "//label[text()='Leave Type']/following::div[1]/child::div[1]")
	@CacheLookup
	private WebElement drpdwnLeaveTypeOnLeaveListPage;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement btnSearchOnLeaveListPage;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button']/child::i[@class='oxd-icon bi-three-dots-vertical']")
	@CacheLookup
	private WebElement verticalLink;
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/child::li/p[text()='Cancel Leave']")
	@CacheLookup
	private WebElement lnkCancelOnLeaveListPage;
	
	@FindBy(xpath = "//span[text()='No Records Found']")
	@CacheLookup
	private WebElement textNoRecordFound;
	
	
  // Leave Request Methods
	
	public void ClickOnLeaveSectionLink() {
		elementUtils.waitForVisibilityOfElement(lnkLeave, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(lnkLeave, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnApplyTapLink() {
		elementUtils.waitForVisibilityOfElement(tapApplyLink, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(tapApplyLink, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnLeaveTypeDrpDwn(String drpDwnElement) {
		elementUtils.waitForVisibilityOfElement(drpdwnLeaveType, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(drpdwnLeaveType, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.selectOptionFromDropDown(drpdwnLeaveTypeOption, drpDwnElement, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setFromDate(String fromDate) {
		elementUtils.waitForVisibilityOfElement(drpdwnFromDate, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(drpdwnFromDate, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(drpdwnFromDate, fromDate, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setToDate(String toDate) {
		elementUtils.waitForVisibilityOfElement(drpdwnToDate, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(drpdwnToDate, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(drpdwnToDate, toDate, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void setCommentsSection() {
		elementUtils.waitForVisibilityOfElement(txtComments, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clearTextFieldUsingActionsClass(txtComments, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.typeTextIntoField(txtComments, "Sick Leave", DriverFactory.EXPLICIT_TIMEOUT);
	}

	public void clickOnApplyBtnOnLeaveApplyPage() {
		elementUtils.clickOnElement(btnApplyOnLeavePage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String getTextApplyOnApplyLeavePage() {
		return elementUtils.getTextFromElement(textApplyLeave, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	//Cancel Leave Request Methods
	
	public void clicksOnLeaveListBtn() {
		elementUtils.waitForVisibilityOfElement(lnkLeaveListTap, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(lnkLeaveListTap, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void selectLeaveTypeFromDropDown(String element) {
		elementUtils.waitForVisibilityOfElement(drpdwnLeaveTypeOnLeaveListPage, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.clickOnElement(drpdwnLeaveTypeOnLeaveListPage, DriverFactory.EXPLICIT_TIMEOUT);
		elementUtils.selectOptionFromDropDown(drpdwnLeaveTypeOption,element , DriverFactory.EXPLICIT_TIMEOUT);		
	}
	
	public void clickOnSearchBtnOnLeaveListPage() {
		elementUtils.clickOnElement(btnSearchOnLeaveListPage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String getLeaveListText() {
		return elementUtils.getTextFromElement(textLeaveList, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnVerticalDotsOnRecordCell() {
		elementUtils.waitForVisibilityOfElement(verticalLink, DriverFactory.EXPLICIT_TIMEOUT);
		//elementUtils.clickOnElement(verticalLink, DriverFactory.EXPLICIT_TIMEOUT);
		verticalLink.click();
	}
	
	public void clickOnCancelBtnOnLeaveListPage() {
		elementUtils.clickOnElement(lnkCancelOnLeaveListPage, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
	public String getTextNoRecordFound() {
		return elementUtils.getTextFromElement(textNoRecordFound, DriverFactory.EXPLICIT_TIMEOUT);
	}
	
}//class


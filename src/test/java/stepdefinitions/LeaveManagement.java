package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LeaveManagementPage;


public class LeaveManagement {
	
	public WebDriver driver;
	private LeaveManagementPage leaveManagementPage;
	
	//Leave Request Methods
	
	@When("User navigate to the Leave section")
	public void user_navigate_to_the_leave_section() {
		driver=DriverFactory.getDriver();
		leaveManagementPage=new LeaveManagementPage(driver);
		leaveManagementPage.ClickOnLeaveSectionLink();
	}
	@And("User click on Apply button")
	public void user_click_on_apply_button() {
		leaveManagementPage.clickOnApplyTapLink();
	}
	@Then("User should see Apply for leave page")
	public void user_should_see_apply_for_leave_page() {
		Assert.assertEquals(leaveManagementPage.getTextApplyOnApplyLeavePage(), "Apply Leave");
	}
	@When("User select Leave Type from dropdown")
	public void user_select_leave_type_from_dropdown() {
		leaveManagementPage.clickOnLeaveTypeDrpDwn("CAN - FMLA");		
	}
	@And("User enters FromDate {string}")
	public void user_enters_from_date(String fromDate) {
		leaveManagementPage.setFromDate(fromDate);
	}
	@And("User enters ToDate {string}")
	public void user_enters_to_date(String toDate) {
		leaveManagementPage.setToDate(toDate);
	}
	@And("User enters comments")
	public void user_enters_comments() {
		leaveManagementPage.setCommentsSection();
	}
	@And("User click on Apply button on leave page")
	public void user_click_on_apply_button_on_leave_page() {
		leaveManagementPage.clickOnApplyBtnOnLeaveApplyPage();
	}
	
	//Cancel Leave Request Methods
	
	@When("User click on LeaveList button")
	public void user_click_on_leave_list_button() {
	 leaveManagementPage.clicksOnLeaveListBtn(); 
	}
	@Then("User should see LeaveList page")
	public void user_should_see_leave_list_page() {
	  Assert.assertEquals(leaveManagementPage.getLeaveListText(), "Leave List");
	}
	@Then("User select Leave Type from dropdrop")
	public void user_select_leave_type_from_dropdrop() {
	  leaveManagementPage.selectLeaveTypeFromDropDown("CAN - FMLA");
	}
	@Then("User click on Search button on leaveList page")
	public void user_click_on_search_button_on_leave_list_page() {
	  leaveManagementPage.clickOnSearchBtnOnLeaveListPage();
	}
	
	@Then("User click on three vertical dots link")
	public void user_click_on_three_vertical_dots_link() throws InterruptedException {
		Thread.sleep(5000);
	  leaveManagementPage.clickOnVerticalDotsOnRecordCell();
	}
	@Then("User click on Cancel button link")
	public void user_click_on_cancel_button_link() throws InterruptedException {
		Thread.sleep(3000);
	  leaveManagementPage.clickOnCancelBtnOnLeaveListPage();
	}
	
	@Then("User should see No Record Found")
	public void user_should_see_no_record_found() {
	  Assert.assertEquals(leaveManagementPage.getTextNoRecordFound(), "No Records Found");
	}


}//class

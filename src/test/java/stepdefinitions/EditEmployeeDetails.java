package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddNewEmployeePage;
import pages.EditEmployeeDetailsPage;
import pages.LoginPage;

public class EditEmployeeDetails {
	
	public WebDriver driver;
	private LoginPage loginpage;
	private AddNewEmployeePage addNewEmployeePage;
	private EditEmployeeDetailsPage editEmployeeDetailsPage;
	
	@Given("User redirected to login page")
	public void user_redirected_to_login_page() {
		driver=DriverFactory.getDriver();
	    loginpage=new LoginPage(driver);
	    addNewEmployeePage=new AddNewEmployeePage(driver);
	    editEmployeeDetailsPage=new EditEmployeeDetailsPage(driver);
	    loginpage.displayStatusOfLoginTextOnPage();
	}
	@When("User enter username {string}")
	public void user_enter_username(String username) {
	   loginpage.setUsername(username);
	}
	@When("User enter password {string}")
	public void user_enter_password(String password) {
	   loginpage.setPassword(password);
	}
	@When("Clicks on Login button")
	public void clicks_on_login_button() {
	   loginpage.clickOnLoginBtn();
	}
	@Then("User should be redirected to the dashboard page")
	public void user_should_be_redirected_to_the_dashboard_page() {
		if(driver.getPageSource().contains("Dashboard")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	try {
	    	Assert.assertTrue(false);
	    	}
	    	catch(Throwable e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
	@When("User navigate to the PIM section")
	public void user_navigate_to_the_pim_section() {
	  addNewEmployeePage.clickOnPIMLink();
	}

	@When("User click on Employee List")
	public void user_click_on_employee_list() {
		   editEmployeeDetailsPage.clickOnEmployeeListLink();
	}
	@When("User enters employeeID {string}")
	public void user_enters_employeeID(String employeeID) {
	    editEmployeeDetailsPage.setEmployeeIDField(employeeID);
	}
	@When("User click Search button")
	public void user_click_search_button() {
		editEmployeeDetailsPage.clickOnSearchBtnOfEmpInfoPage();
	}
	
	@When("User click on record cell row")
	public void user_click_on_record_cell_row() {
		editEmployeeDetailsPage.clickOnRecordFoundCell();
	}
	
	@Then("User update the Last Name to {string}")
	public void user_update_the_last_name_to(String lastname) {
	   editEmployeeDetailsPage.setLastNameField(lastname);
	}
	@Then("User update the Date Of Birth {string} of employee")
	public void user_update_the_date_of_birth_of_employee(String dob) {
	   editEmployeeDetailsPage.setDateOfBirth(dob);
	}
	@Then("User select Gender of employee")
	public void user_select_gender_of_employee() {
	   editEmployeeDetailsPage.selectGender();
	}
	@Then("User click the Save button")
	public void user_click_the_save_button() {
	   editEmployeeDetailsPage.clickOnSaveBtnOfPersonalDetailsPage();
	}
	@Then("User click on Job tap")
	public void user_click_on_job_tap() {
	   editEmployeeDetailsPage.clickOnJobTap();
	}
	
	@Then("User should see proper page")
	public void user_should_see_proper_page() {
	   if(driver.getPageSource().contains("Job Details")){
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertFalse(false);
	   }
	}
	
	@Then("User select Joined Date {string} from calender")
	public void user_select_joined_date_from_calender(String joinedDate) {
		editEmployeeDetailsPage.setJoinedDateOfJob(joinedDate);
	}
	
	@Then("User select Job Category from dropdown")
	public void user_select_job_category_from_dropdown() {
	  editEmployeeDetailsPage.setJobCategory("Professionals");
	}

	@Then("User click on Save button")
	public void user_click_on_save_button() {
	  editEmployeeDetailsPage.clickSaveBtnOnJobPage();
	}
	
	@When("User click on trash icon")
	public void user_click_on_trash_icon() {
	  editEmployeeDetailsPage.clickOnTrashButton();
	}
	
}//class

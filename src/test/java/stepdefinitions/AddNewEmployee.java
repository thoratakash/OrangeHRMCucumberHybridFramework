package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddNewEmployeePage;
import pages.LoginPage;
import utils.ElementUtils;

public class AddNewEmployee {
	
	public WebDriver driver;
	private LoginPage loginpage;
	private AddNewEmployeePage addNewEmployeePage;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver=DriverFactory.getDriver();
		loginpage=new LoginPage(driver);
		addNewEmployeePage=new AddNewEmployeePage(driver);
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
	   loginpage.setUsername(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
	   loginpage.setPassword(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	   loginpage.clickOnLoginBtn();
	}

	@Then("User should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
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

	@When("User navigate to PIM section")
	public void user_navigate_to_pim_section() {
	   addNewEmployeePage.clickOnPIMLink();
	}

	@When("User click on Add Employee")
	public void user_click_on_add_employee() {
	   addNewEmployeePage.clickOnAddEmployeeLink();
	}

	@When("User enters below employee details")
	public void user_enters_below_employee_details(DataTable dataTable) {
		Map<String, String> dataSet = dataTable.asMap(String.class,String.class);
		addNewEmployeePage.setFirstNameField(dataSet.get("FirstName"));
		addNewEmployeePage.setMiddleNameField(dataSet.get("MiddleName"));
		addNewEmployeePage.setLastNameField(dataSet.get("LastName"));
		addNewEmployeePage.setEmployeeID(dataSet.get("EmployeeID"));
	}

	@When("User enable Create Login Details switch")
	public void user_enable_create_login_details_switch() {
	  addNewEmployeePage.clickOnCreateLoginCheckBox();
	}
	
	@When("User enters username for login details")
	public void user_enters_username_for_login_details() {
		String randomGeneratedString = ElementUtils.randomString();
		addNewEmployeePage.setUsernameForLogin(randomGeneratedString);
	}
	
	
	@When("User enters below login details of employee")
	public void user_enters_below_login_details_of_employee(DataTable dataTable) {
	  Map<String, String> dataSet = dataTable.asMap(String.class,String.class);
	  addNewEmployeePage.setUsernameForLogin(dataSet.get("Username"));
	  addNewEmployeePage.setPasswordForLogin(dataSet.get("Password"));
	  addNewEmployeePage.setConfirmPasswordForLogin(dataSet.get("ConfirmPassword"));
	}
	
	@When("Select status radio button")
	public void select_status_radio_button() {
	  addNewEmployeePage.selectRadioButton();
	}
	
	@When("User click Save button")
	public void user_click_save_button() {
	 addNewEmployeePage.clickOnSaveBtn();
	}

	@Then("User should see proper message")
	public void user_should_see_proper_message() {
	  Assert.assertEquals(addNewEmployeePage.displayStatusOfProfileNameText(), "Personal Details");
	}
	
	@Then("User should see proper warning message")
	public void user_should_see_proper_warning_message() {		
	  Assert.assertEquals(addNewEmployeePage.displayStatusOfEmployeeIDAlreadyExist(), "Employee Id already exists");
	}

}//class


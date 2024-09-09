<h1 align="center">OrangeHRMCucumberHybridFramework</h1>

<h2 align="center">Introduction to Cucumber-Selenium Project for "OrangeHRM" Demo Site.</h2>

Overview
------------
The OrangeHRM Cucumber Hybrid Framework is designed to automate testing for the **OrangeHRM** application using a combination of Cucumber, Selenium WebDriver, and TestNG. The hybrid framework leverages the strengths of BDD (Behavior-Driven Development) with Cucumber for writing tests in a readable format and TestNG for managing test execution, reporting, and configuration. Selenium WebDriver is used for interacting with the web application.

Objectives
------------

- **Automate Functional Testing:** Ensure that all features of the OrangeHRM application work as expected.

- **Maintain Readable Test Cases:** Utilize Cucumber’s Gherkin syntax to write test cases in a business-readable format.
  
- **Ensure Test Management:** Use TestNG for better test configuration, parallel execution, and reporting.
  
- **Enhance Reusability:** Structure the framework to promote reuse of code and test scenarios.
  
- **Ensure Consistency:**  Confirm that the site's features work as expected across different browsers and environments.
  
- **Improve Test Efficiency:**  Reduce manual testing effort and increase test coverage by automating test scenarios.


Tools and Technologies
-----------------------
  
- **Java:** Programming language used for implementing test automation.
  
- **Selenium WebDriver:** A browser automation tool that enables interaction with the web application's user interface. It supports multiple browsers and provides a robust framework for automating web application tests.
  
- **Cucumber:** A tool for behavior-driven development (BDD) that allows writing test scenarios  in a **Gherkin** format. It helps in defining application behavior in a way that is easily understandable by non-technical stakeholders.
  
- **TestNG:** Testing framework for running tests, generating reports, and managing test configurations.
  
- **Maven:** Build automation tools to manage dependencies and build processes.

-  **Gherkin:** The language used by Cucumber to write test scenarios in a Given-When-Then format.




Project Structure
------------------

- **Feature Files:** Written in Gherkin, these files describe the behavior of the application from an end-user perspective. 
     They are stored in the **src/test/resources/features** directory and contain scenarios and steps that outline the expected behavior.

- **Step Definitions:** Java classes that implement the steps defined in the feature files. They are located in the **src/test/java/stepDefinitions** directory and contain the code to interact with the web application using Selenium WebDriver.

- **Page Objects:** Classes representing the pages of the web application. They encapsulate the interactions with the web elements and help in organizing the test code. These are found in the **src/test/java/pageObjects** directory.

- **Test Runner:** A class responsible for running the Cucumber tests. It is configured to specify which feature files and step definitions to use, and it can be found in the **src/test/java/runner** directory.

- **Hooks:** Contains hooks for setup and teardown actions.

- **Utils:** Contains utility classes like ElementUtils. Present all common methods used throughout the entire application.

- **Configuration Files:** Files that define the test environment and other settings. For example, config.properties file may be used to configure the test execution environment-specific variables such as browser settings, URLs, and timeouts, are easily configurable and consistently applied throughout the test framework.


Example Scenarios
------------------

**Login Functionality:** 

- **Valid Credentials:** Test logging in with valid credentials and verify that the user is redirected to the appropriate page, such as the account dashboard or homepage.

- **Invalid Credentials:** Test logging in with incorrect credentials to ensure that the system displays an appropriate error message and does not grant access.

- **Empty Fields:** Ensure that the system handles cases where the login form is submitted with empty fields.

**Add New Employee:** 

- This feature is focused on the ability of an HR manager to add a new employee to the system. The feature ensures that the HR manager can record new employees correctly and verify that the employee details are saved and displayed properly.


**Edit Employee Details:** 

- This feature allows an HR manager to update the details of an existing employee. The feature ensures that the employee's information can be modified and that changes are correctly saved and displayed.

**Applying For Leave:** 

- This scenario tests the process of an employee applying for leave. It ensures that after logging in, the user can successfully navigate to the Leave Management section, apply for leave, and receive confirmation of the submission.

**Cancel Leave:** 

- This scenario tests the process of an employee cancelling a previously submitted leave request. It ensures that after logging in, the user can successfully navigate to the Leave Management section, locate the leave request, and cancel it, receiving confirmation of the cancellation.

**Logout Functionality:** 
  - This scenario tests the process of logging out from the OrangeHRM application. It ensures that after logging in, the user can successfully log out and is redirected to the login page.

**Forgot Password Functionality:** 

- This scenario tests the process for a user to reset their password if they forget it. It ensures that the user can request a password reset and receive instructions to set a new password.

**Change Password Functionality:** 

- This scenario tests the process of a user changing their current password to a new one. It ensures that after logging in, the user can navigate to the password change section, enter the required information, and successfully update their password.

Benefits
---------

- **Improved Communication:** The use of Gherkin allows both technical and non-technical team members to understand and contribute to the test scenarios.

- **Automated Regression Testing:** Automated tests can be run frequently to catch regressions early, improving software quality and stability.

- **Readable Test Cases:** Cucumber allows writing scenarios in a natural language format that is easy for stakeholders to understand.

- **Modular and Maintainable:** The Page Object Model helps in keeping the code modular and easier to maintain.

- **Comprehensive Reporting:** Cucumber provides detailed test reports, which helps in identifying issues quickly.

- **Reusable Code:** Utilities and reusable methods promote efficiency and reduce duplication.


Questions / Contact / Contribute
---------------------------------
Feel free to fork this repo, add to it, and create a pull request if you like to contribute.  

If you have any questions, you can contact me via email: `thorata89@gmail.com`


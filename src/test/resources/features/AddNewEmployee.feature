@all
Feature: Add New Employee with login details

Background:
    Given User is on login page
    When User enters username "Admin" 
    And User enters password "admin123"
    And Click on Login button
    Then User should be on the dashboard page
    When User navigate to PIM section
    And User click on Add Employee
 
@addnewemployee @newemployeewithlogindetails @smoke @regression
  Scenario: Add a new employee with proper login details
    And User enters below employee details
      | FirstName     |Rakesh |
      | MiddleName|Akash   |
      | LastName      |Thorat  |
      | EmployeeID  |786358|
    And User enable Create Login Details switch
    And User enters below login details of employee
       |Username                |Rakesh|
      | Password                 |Rakesh123 |
      | ConfirmPassword |Rakesh123 |
    And Select status radio button
    And User click Save button
   Then User should see proper message
   
@addnewemployee @withoutlogin @smoke @regression
  Scenario: Add a new employee without login details
    And User enters below employee details
      | FirstName     |Vijay    |
      | MiddleName|Rakesh|
      | LastName      |Patil   |
      | EmployeeID  |987654|
    And User click Save button
   Then User should see proper message
   
   @addnewemployee @duplicateempid @smoke @regression
  Scenario: Add a new employee with duplicate Employee ID
    And User enters below employee details
      | FirstName     |Rahul    |
      | MiddleName|Prakash|
      | LastName      |Thorat   |
      | EmployeeID  |786358 |
    And User enable Create Login Details switch
    And User enters below login details of employee
       | Username               |Rahul        |
      | Password                 |Rahul123 |
      | ConfirmPassword |Rahul123 |
    And Select status radio button
    And User click Save button
   Then User should see proper warning message
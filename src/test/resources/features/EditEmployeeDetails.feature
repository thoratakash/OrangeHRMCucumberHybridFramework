@all
Feature: Edit Employee Details

  Background:
    Given User redirected to login page
    When User enter username "Admin" 
    And User enter password "admin123"
    And Clicks on Login button 
    Then User should be redirected to the dashboard page

@editemployeedetails @smoke @regression
  Scenario: Edit an employee's details
     When User navigate to the PIM section
     And User click on Employee List
     And User enters employeeID "786358" 
     And User click Search button
    And  User click on record cell row
    And User update the Last Name to "Tiwari"
    And User update the Date Of Birth "2024-06-20" of employee
    And User select Gender of employee
    And User click the Save button
    And User click on Job tap
   Then User should see proper page
   And User select Joined Date "2023-09-04" from calender
   And User select Job Category from dropdown
   And User click on Save button

  @deleteemployee @smoke @regression
  Scenario: Delete an employee from records
     When User navigate to the PIM section
     And User click on Employee List
     And User enters employeeID "786358" 
     And User click Search button
     And User click on trash icon
 
     
     
     
     
     
     
     
  

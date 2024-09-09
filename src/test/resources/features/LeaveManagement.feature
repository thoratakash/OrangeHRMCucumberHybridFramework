#Leave Management
@all
Feature: Leave Management

  Background:
    Given User redirected to login page
    When User enter username "Admin" 
    And User enter password "admin123"
    And Clicks on Login button 
    Then User should be redirected to the dashboard page

@leaverequest @smoke @regression
  Scenario: Apply for leave
     When User navigate to the Leave section
     And User click on Apply button
     Then User should see Apply for leave page
     When User select Leave Type from dropdown
     And User enters FromDate "2024-15-08"
     And User enters ToDate "2024-16-08"
     And User enters comments
     And User click on Apply button on leave page
     
@cancelleaverequest @smoke @regression
  Scenario: Cancel Leave Request
     When User navigate to the Leave section
     And User click on LeaveList button
     Then User should see LeaveList page
     And User enters FromDate "2024-15-08"
     And User enters ToDate "2024-16-08"
     And User select Leave Type from dropdrop
     And User click on Search button on leaveList page  
     And User click on three vertical dots link
     And User click on Cancel button link  
     Then User should see No Record Found
     
   
    
 
     
     
     

     
     
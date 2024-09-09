@all
Feature: Logout Functionality

 @logout @smoke @regression
  Scenario: User logs out successfully
   When User enters details into below fields
   |username          |Admin|
   |password          |admin123|
    And user click the login button
    Then user should redirected to the dashboard
    When user clicks on the profile icon
    And user clicks on the Logout button
    Then user should redirected to the login page
    


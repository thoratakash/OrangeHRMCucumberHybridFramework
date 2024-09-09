@all
Feature: Forgot Password Functionality
  @forgotpassword @smoke @regression
  Scenario: User requests a password reset request
    Given User is on the login page
    When User click on the Forgot your password link
    Then User should be redirected to the password reset page
     When User enters valid username "Admin" 
    And User click on the Reset Password button
    Then User should see a confirmation message indicating that an email has been sent
   
   @forgotpassword @forgotpasswordwithemptyusername @smoke @regression
  Scenario: User requests a password reset with an empty username address
    Given User is on the login page
    When User click on the Forgot your password link
    Then User should be redirected to the password reset page
     When User dont enter username 
    And User click on the Reset Password button
    Then User should see a proper warning message
   

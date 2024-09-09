#Update Password
@all
Feature: Change Password Functionality

  Background:
    Given User redirected to login page
    When User enter username "Rakesh" 
    And User enter password "Rakesh123"
    And Clicks on Login button 
    Then User should be redirected to the dashboard page

@changepassword @smoke @regression
  Scenario: Change Password
     When User clicks on UserProfile
     And User clicks on Change Password link
     Then User should see Update Password page
     When User enters Current Password "Rakesh123"
     And User enters Password "Akash123"
     And User enters Confirm Password "Akash123"
     And User clicks on Save Button
     

# all annotation is common for all scenarios present in login feature file
@all
Feature: Login Functionality

# Scenario for Login functionality
@login @validcredentials @smoke @regression
    Scenario Outline: User logs in with valid credentials
    Given user is on the login page
    When user enters valid username <username> 
    And user enters valid password <password>
    And user clicks the login button
    Then user should be redirected to the dashboard
    Examples:
    |username|password|
    |Admin|admin123|
    |Rahul|Rahul123|
    
@login @invalidcredentials @smoke @regression
   Scenario: User logs in with both invalid username and password
    Given user is on the login page
    When user enters invalid username "Adm456" 
    And user enters invalid password "adm789"
    And user clicks the login button
    Then User should get a proper warning message
    
    @login @nocredentials @smoke @regression
    Scenario: User attempts to log in with empty username and password
     Given user is on the login page
    When user leaves both the username and password fields empty
    And user clicks the login button
    Then an error message should be displayed indicating Username and Password are required
       
    
    
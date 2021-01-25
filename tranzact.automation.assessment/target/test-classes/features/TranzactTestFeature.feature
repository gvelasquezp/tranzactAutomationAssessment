Feature: Tranzact Automation Assessment

  Scenario Outline: Register user in Registration page
    Given I open the Home page
    And I click on Sign in button
    And I enter my email address
    And I click on Create Account button
    When I fill all fields for <name> & <lastname> user
    And I click on Register button
    Then I access to my account page
    And I logout from my account page
    
    Examples:
    |name				|lastname 	|
    |Guillermo	|Velasquez	|
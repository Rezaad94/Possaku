@Login
Feature: Login

  @Invalid_login
  Scenario Outline: User able to login with valid credential
    Given User Open App
    And User Navigate to Login Page
    When User input <phone> and <PIN>
    And User click login button
    Then Verification Invalid Login Appear

    Examples: 
      | phone 				| PIN    	|
      | 123 					| 12345 	|
      | empty					| empty		|
      | empty					| 123456	|
		
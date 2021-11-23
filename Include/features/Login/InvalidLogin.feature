@Login
Feature: Login

  @Invalid_login
  Scenario Outline: User unable to login with invalid credential
    Given User Navigate to Login Page
    When User input <phone> and <PIN>
    And User click login button
    Then Verification Invalid Login Appear

    Examples: 
      | phone 				| PIN    	|
      | 123 					| 12345 	|
      | 085879214397	| 123			|
      | empty					| empty		|
      | empty					| 123456	|
      | 085879214397	| empty 	|
		
@Login
Feature: Login

  @valid_login
  Scenario Outline: User able to login with valid credential
    Given User Navigate to Login Page
    When User input <phone> and <PIN>
    And User click login button
    Then User navigate to home page

    Examples: 
      | phone          	| PIN    |
      | 085879214397 		| 111111 |
      | +6285879214397 	| 111111 |



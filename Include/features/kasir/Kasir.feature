@Kasir
Feature: Kasir

  @Kasir_1
  Scenario: User able to make transaction with tunai method payment
    Given User navigate to chasier page
    And User select item from katalog
    And User navigate to cart page
    And User select Tunai Method payment
    When User finish transaction
    Then User Navigate to success page


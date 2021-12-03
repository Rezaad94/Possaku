@Kasir
Feature: Kasir

  #@Kasir_1
  #Scenario: User able to create transaction with tunai method payment
    #Given User navigate to chasier page
    #And User Navigate to Catalog
    #And user select item in sembako
    #And user add item to cart
    #And User navigate to cart page
    #And User select Tunai Method payment
    #When User finish transaction
    #Then User Navigate to success page
    #And User back to homepage by click kembali ke beranda button

  @kasir_2
  Scenario Outline: User able to search product in katalog
    Given User navigate to chasier page
    And User Navigate to Catalog
    When user search availabe product with <keyword>
    Then user find that product
    And user select item from search result
    And user add item to cart

    Examples: 
      | keyword   |
      | pensil 2b |

Feature: Checkout

  Scenario: Checkout a banana
    Given the price of a "banana" is 40c
    When I checkout 1 "banana"
    Then the total price should be 40c

  Scenario Outline: Checkout bananas
    * the price of a "banana" is 40c
    * I checkout <count> "bananas"
    * the total price should be <total>c
    Examples:
      | count | total |
      | 1     | 40    |
      | 2     | 80    |

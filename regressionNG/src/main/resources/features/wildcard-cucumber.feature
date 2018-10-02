Feature: Cash withdrawal

  Scenario: Successful withdrawal from an account in credit
    Given I have $100 in my account
    When I request $20
    Then $20 should be dispensed

    Scenario: Digit whildcard
      Given I have $200 in my account

    Scenario: Digit and Word wildcard
      Given the flight EZY4567 is leaving today
      And the flight C038 is leaving today
      And the flight BA01618 is leaving today

    Scenario: Question mark operator
      Given I have 1 cucumber in my basket
      Given I have 10 cucumbers in my basket

    Scenario: Avoid repetition of steps
      Given I visit the homepage
      Given I go to the homepage


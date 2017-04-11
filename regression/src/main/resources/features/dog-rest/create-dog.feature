@regression @rest
Feature: Create a new dog

  Scenario: Create dog endpoint creates a new dog
    Given I have "valid" dog details
    When I call create dog endpoint
    Then I should see a new dog created successfully
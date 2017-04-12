@regression @rest
Feature: Create a new dog

  Scenario: Create dog endpoint creates a new dog
    Given I have "unique" dog details
    When I call create dog endpoint
    Then I should see a new dog created successfully

  Scenario: Create dog endpoint does not create a duplicate dog
    Given I have "unique" dog details
    And I call create dog endpoint
    When I call create dog endpoint with the same dog details
    Then I should see an error response
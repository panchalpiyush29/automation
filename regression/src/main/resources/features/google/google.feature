@regression
Feature: Do a google search

  Background:
    Given I am on google page

  Scenario: Google search should return the correct result
    Given I have a "valid" search query
    When I perform a search on google landing page
    Then I should see the correct result
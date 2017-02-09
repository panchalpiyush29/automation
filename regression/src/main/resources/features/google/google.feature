@regression
Feature: Do a google search

  Background:
    Given I am google page

  Scenario: Google search should return the correct result
    Given I have a "valid" search query
    When I search on google
    Then I can see the correct result
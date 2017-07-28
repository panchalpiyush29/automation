@regression @google
Feature: Do a google search

  Background:
    Given I am not logged in
    Given I am on google page

  Scenario: Google search should return the correct result
    Given I have a "valid" search query
    When I perform a search on google landing page
    Then I should see the correct result

  Scenario: Valid user should login sucessfully to gmail
    Given I am on gmail login page
    And I am a "valid" user
    When I enter my credentials
    Then I can see my mailbox

  ## This test is meant to fail for a failed report on jenkins
  Scenario: Valid user should login sucessfully to gmail
    Given I am on gmail login page
    And I am a "invalid" user
    When I enter my credentials
    Then I can see my mailbox
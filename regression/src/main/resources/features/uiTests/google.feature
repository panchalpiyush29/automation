@regression @google
Feature: Google search and sign-up

  Background:
    Given I am on google page

  Scenario: Google search should return the correct result
    Given I have a "valid" search query
    When I perform a search on google landing page
    Then I should see at least 5 correct result

  #Note: Success Message test will fail for incorrect email format this is meant to drive our Report
  Scenario: Sign up a google user
    Given I have a "unique" user details
    When I fill the google sign up form
    Then I can see a success message
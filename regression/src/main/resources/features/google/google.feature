@regression @google
Feature: Google search and sign-up

  Background:
    Given I am on google page

  Scenario: Google search should return the correct result
    Given I have a "valid" search query
    When I perform a search on google landing page
    Then I should see the correct result

  Scenario: Sign up a google user
    Given I have a "unique" user details
    When I fill the google sign up form
    #Then my user should be created
    #Then I get a captcha err message
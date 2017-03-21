@login @wip
Feature: Login with a valid user

  Scenario: I can login successfully
    Given I am a "valid" user
    When I login as the user
    Then I can see the welcome page after skipping the welcome video
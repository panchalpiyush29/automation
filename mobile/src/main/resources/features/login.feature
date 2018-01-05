@regression @login
Feature: Login with a valid user

  Scenario: I can login successfully
    Given I am a "valid" user
    When I login as the user
    Then I can see a login successful message

  Scenario: I can login with another user's details
    Given I am a "another-valid" user
    When I login as the user
    Then I can see a login successful message

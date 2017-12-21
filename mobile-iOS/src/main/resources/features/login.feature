@regression @login
Feature: Login with a valid user

  Scenario: I can login successfully
    Given I am a "valid" user
    When I login as the user
    Then I can see a login successful message
@top-up
Feature: Login with a valid user

  Background: I am logged in
    Given I am a "valid" user
    When I login as the user


  Scenario: I can login successfully
    Then I can see the Hamburger icon

  Scenario: I can logout successfully
    Then I can Logout

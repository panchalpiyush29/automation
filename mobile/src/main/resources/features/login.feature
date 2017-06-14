@android
Feature: Login and Logout on Android

  Background: I am logged in
    Given I am a "valid" user
    When I login as the user


  Scenario: I can login successfully using prePaid number
    Then I can see the Hamburger icon

  Scenario: I can logout successfully
    Then I can Logout

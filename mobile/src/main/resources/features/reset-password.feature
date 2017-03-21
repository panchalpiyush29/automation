@regression @resetPassword
Feature: Reset my password

  Scenario: I can reset my password successfully
    Given I am a "valid" user
    When I reset my password
    Then I can see the success message
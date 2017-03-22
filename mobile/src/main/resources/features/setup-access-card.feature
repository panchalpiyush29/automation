@accessCard
Feature: Setting up my new access card

  Background: I am logged in
    Given I am a "valid" user
    And I login as the user
    And I can see the welcome page after skipping the welcome video

  Scenario: Setting up my new access card
    Given I navigate to the set up access card section
@SPB @regression
Feature: Test Demo Saint Petersburg bank

  Scenario: User can login to SPB Demo
    Given User is on SPB Demo login page
    When User enters "valid" credentials
    Then User greeting "<Hello World>" is displayed


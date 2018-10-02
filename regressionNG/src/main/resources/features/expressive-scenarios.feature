Feature: User's

  Scenario: Various users
    Given these users:
      | name            | date of birth  |
      | Michael Jackson | August 29,1958 |
      | Elvis           | January 8,1935 |
      | John Lennon     | October 9,1940 |

  Scenario: Tic tac Toe
    Given a board like this:
      |   | 1 | 2 | 3 |
      | 1 |   |   |   |
      | 2 |   |   |   |
      | 3 |   |   |   |
    When player x plays in row 2, column 1
    Then the board should look like this:
      |   | 1 | 2 | 3 |
      | 1 |   |   |   |
      | 2 | x |   |   |
      | 3 |   |   |   |

  Scenario Outline: Withdraw fixed amount
    Given I have <Balance> with me
    When I choose to withdraw the fixed amount of <Withdrawal>
    Then I should receive <Received> cash
    And the balance of my account should be <Remaining>
    Examples:
      | Balance | Withdrawal | Received | Remaining |
      | $500    | $50        | $50      | $450      |


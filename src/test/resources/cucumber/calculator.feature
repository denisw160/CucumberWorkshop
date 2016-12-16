Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  # Default scenario with integers as input
  Scenario: Add two numbers
    Given I have a calculator
    When I add 2 and 3
    Then the result should be 5

  # Scenarios with double or negative values
  Scenario: Add two double numbers
    Given I have a calculator
    When I will add two number 2.5 and 3.5
    Then the result should be number 6.0

  Scenario: Add two numbers with one negative
    Given I have a calculator
    When I will add two number 2 and -3
    Then the result should be number -1

  # Multiple Inputs
  Scenario Outline: Adding more samples
    Given I have a calculator
    When I add <number1> and <number2>
    Then the result should be <result>

    Examples:
      | number1 | number2 | result |
      | 1       | 2       | 3      |
      | 2       | 0       | 2      |
      | 0       | 0       | 0      |
      | 500     | 1000    | 1500   |

  # New Scenarios
  Scenario: Multiply two numbers
    Given I have a calculator
    When I multiply 2 and 3
    Then the result should be 6

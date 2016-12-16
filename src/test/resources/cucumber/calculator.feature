Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  Scenario: Add two numbers
    Given I have a calculator
    When I add 2 and 3
    Then the result should be 5

  Scenario: Add two double numbers
    Given I have a calculator
    When I will add two number 2.5 and 3.5
    Then the result should be number 6.0

  Scenario: Add two numbers with one negative
    Given I have a calculator
    When I will add two number 2 and -3
    Then the result should be number -1
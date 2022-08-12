Feature: Background Example

  Background:
    Given Precondition1
    And Precondition2

  @Background
  Scenario: Example1
    When Test step Nr1 firstName is "Hakan" and lastName is "Kurhan"
    And Test step nr2 age is 30
    Then Validation Nr1
    And Validation Nr2

  @Background
  Scenario: Example2
    When Test step Nr3
    And Test step nr4
    Then Validation Nr3
    And Validation Nr4
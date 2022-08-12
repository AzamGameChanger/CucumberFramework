#Author Azam Ibragimov
@signal
Feature: Signal Telecom Sign In

  @invalid
  Scenario: Invalid credentials sign in
    When User enters invalid email
    And USer enters an invalid password
    And User clicks on Sign In button
    Then User sees an error message

  @empty
  Scenario: Empty Email Sign In
    When User leaves username email
    And USer enters an invalid password
    And User clicks on Sign In button
    Then User sees an error message
    And User validates the error message

  @parametrized
  Scenario: Parametrized Sign In
    When User enters an invalid username as  "jama@gmail.com"
    And User enters an invalid password as "wow-wow"
    And User clicks on Sign In button
    Then User sees an error message

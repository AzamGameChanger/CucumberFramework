#Author Azam Ibragimov
Feature: Sign In Telecom with Examples
    # Backgroud not required for my test

  @examples
  Scenario Outline: Sign In with Examples
    When User enters an invalid username as  "<username>"
    And User enters an invalid password as "<password>"
    And User clicks on Sign In button
    Then User sees an error message
    Examples:
      | username        | password    |
      | user1@gmail.com | password123 |
      |                 | password321 |
      | user1@gmail     |             |
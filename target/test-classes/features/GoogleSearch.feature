Feature: Searching in Google

  Scenario: Searching by typing
    Given I navigated to google
    When I type a search item in the search box
    And I click on the search button
    Then I see the result of my search
    And I see the number of results

  Scenario: Searching by voice
    Given I navigated to google
    When I say what I want to search
    Then I see the result of my search
    And I see the number of results
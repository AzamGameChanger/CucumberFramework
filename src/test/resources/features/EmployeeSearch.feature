Feature: Search for employee


  Scenario: Search employee by ID
    Given User is logged in with valid credentials
    And User navigates to the employee user pages
    When User enters valid employee ID
    And Clicks on search button
    Then Employee information is displayed


  Scenario: Search employee by firstname and lastname
    Given User is logged in with valid credentials
    And User navigates to the employee user pages
    When User enters valid employee first and last name
    And Clicks on search button
    Then Employee information is displayed
#@LoginFunctionality
Feature: Login Functionality

  @smoke #@regression
  Scenario: Valid Login
    #Given I navigated to Orange HRM website
    When  I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    #Then I quit the browser

  @smoke1
  Scenario: Invalid Password
    #Given I navigated to Orange HRM website
    When  I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that Invalid credentials message is displayed
    #Then I quit the browser

  @HW
  Scenario: Login using Scenario
    When user enters login info "TimoWerner" and "Werner3366"
    And I click on login button
    Then Welcome "Timo" message is displayed

  @HW2
  Scenario Outline: Login using Scenario Outline and Example Table
    When user enters login info "<username>" and "<password>"
    And I click on login button
    Then Welcome "<firstname>" message is displayed
    Examples:
      | username    | password   | firstname |
      | Admin       | admin123   | Paul      |
      | TimoWerner  | secret2244 | Timo      |
      | SalomonKalu | secret5566 | Salomon   |

  @HW3
  Scenario: Login using Datatable
    When user enters username and password and clicks on login
      | username    | password   | firstname |
      | Admin       | admin123   | Paul      |

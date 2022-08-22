# Author Codewithazam

@
Feature: Generate Token API

  Background:
    Given I create a generate token request
    And I provide the header for generate token request
    And I provide the body for generate token request

  @token
  Scenario: Generating Token
    When I make a Post call to generate token endpoint
    Then I validate that the status code for generate token request is 200
    And I validate that body contains "authorized successfully"
    And I validate that the value of "result" is "User authorized successfully."
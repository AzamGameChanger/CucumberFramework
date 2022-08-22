#author Azam Academy

@OneBook
Feature: Get One Book API
  Description: This feature test Get One Book API

  Background:
    Given I create a get one book request
    And I provide ISBN "9781449337711" as a query parameter

  Scenario: Getting one book and validating the response
    When I make a Get call to the Get One Book endpoint
    Then I validate that status code for getting a book is 200
    And I validate that the ISBN in the response body is "9781449337711"
    And I validate that book title is "Designing Evolvable Web APIs with ASP.NET"
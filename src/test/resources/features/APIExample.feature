# Author Azamkhuja

  Feature: Add book to account API
    Background:
      Given A token is generated

    @API
    Scenario: Adding a book and validating the account
      When I add a book to the account
      And I get the account information
      Then I validate that the book is in the account
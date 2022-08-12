#Author Azamkhuja Ibragimov
Feature: Add Employee With Personal Details

  Background:
    Given User is logged in with valid credentials
    And User navigates to the add employee page

  @HW4
  Scenario Outline: Add and Modify Employee Details
    When user enters employee first name "<FirstName>" and last name "<LastName>"
    And user clicks on save button
    And I click on Personal Details Edit
    Then I am able to modify Employee Details "<DriverLicence>", "<ExpirationDate>", "<SSN>", "<Gender>", "<Nationality>"
    And I click on Personal Details Save

    Examples:
      | FirstName | LastName | DriverLicence | ExpirationDate | SSN         | Gender | Nationality |
      | Melanie   | Dorsey   | N78787886     | 2024-02-08     | 123-45-6789 | Male   | French      |
      | Kamil     | Jammy    | T55578855     | 2023-05-10     | 234-56-7890 | Female | Estonian    |
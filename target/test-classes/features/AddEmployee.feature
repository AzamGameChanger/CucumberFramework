Feature: Add Employee

  Background:
    Given User is logged in with valid credentials
    And User navigates to the add employee page


  @AddEmployee
  Scenario: Add employee with first and last name
    When user enters employee first name "Samandar" and last name "Samandarov"
    And user clicks on save button
    Then validate that employee "Samandar Samandarov" is added successfully

  @second
  Scenario:  Add Employee without employee id
    When user enters employee first name and last name
    And user deletes employee id
    And user clicks on save button
    Then validate that employee is added successfully

  @third
  Scenario: Add Employee and create login Credentials
    When user enters employee first name and last name
    And user clicks on Create Login details
    And user provides credentials
    And user clicks on save button
    Then validate that employee is added successfully

    #performing DDT using Scenario Outline and Example keyword ( boss - feature file)
  @scenarioOutline
  Scenario Outline: Adding multiple employees
    When user enters employee "<firstName>", "<middleName>" and "<lastName>"
    And user clicks on save button
    Then validate that "<firstName>", "<middleName>" and "<lastName>" is added successfully
    Examples:
      | firstName | middleName | lastName |
      | Jameson   | J          | Addison  |
      | Emomodin  | G          | Maddison |
      | Jessy     | Y          | Harrison |

    #performing DDT using DataTable (boss - AddEmployeeSteps)
  @dataTable
  Scenario: Adding multiple employees
    When user enters employee details and clicks on save and validates it is added
      | firstName | middleName | lastName |
      | Mendez    | S          | Davidson |
      | Besnik    | T          | Karlson  |

    @excelData
    Scenario: Add multiple employees from Excel
      When  user enters employee data from "Employee" excel sheet

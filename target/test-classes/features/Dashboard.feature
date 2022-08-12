Feature: Dashboard menu

  @menu
  Scenario: Dashboard menu for admin
    Given User is logged in with valid credentials
    When I want to see this items in the menu
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Buzz        |
Feature: Writing Scenario Outline example

  @Outline
  Scenario Outline:
    When Login with "<username>" and "<password>"
    And I click on login button
    Then I validate the Welcome "<username>" is displayed
    And We say bye "<fullname>"
    Examples:
      | username | password    | fullname   |
      | Flori    | EdiRama@123 | DominoBoss |
      | Komron   | Horosho@_   | PutinLover |
      | Enes     | Atlas@ets   | ReisHater  |
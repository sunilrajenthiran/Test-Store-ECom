Feature: User SignUp

  Scenario Outline: User Sign Ups Sucessfully
    Given user is on the signup page
    When user select "<Gender>" and enters "<FirstName>" and "<LastName>"
    And user enters "<Email>" "<Password>" and "<BirthDate>"
    Then user selects tick boxes
    And clicks on Save button
    Then user should be registered sucessfully as "<Expected>"

    Examples: 
      | Gender | FirstName | LastName | Email                        | Password  | BirthDate  | Expected |
      | Mr     | Sunil     | R        | sunilrajenthiran18@gmail.com | Sunil@123 | 08/13/2003 | Sunil R  |

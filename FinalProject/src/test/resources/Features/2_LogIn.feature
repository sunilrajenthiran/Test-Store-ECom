Feature: User Login

  Scenario Outline: User Login Sucessfully
    Given user is on Login Page must Signout before Login
    When user enters "<Email>" and "<Password>"
    And user clicks on Sign button
    Then user should be Loggedin sucessfully by "<Name>"

    Examples: 
      | Email                        | Password  | Name    |
      | sunilrajenthiran12@gmail.com | Sunil@123 | Sunil R |

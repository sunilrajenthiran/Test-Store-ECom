Feature: Add products in wishlists

  Scenario Outline: Add Products into wishlist
    Given user search for the product using "<Search Box>"
    When user selects desired "<Product>" from search list
    And user clicks Wishlist icon selects default list
    Then user ensure product is added by "<Sucess Msg>"

    Examples: 
      | Search Box | Product             | Sucess Msg    |
      | Notebook   | Brown bear Notebook | Product added |

  Scenario Outline: Create new Wishlist
    Given user search for the product using "<Search Box>"
    When user selects desired "<Product>" from search list
    And user clicks Wishlist icon selects Create New List and add "<New Wishlist Name>" to create and ensure as "<List Created>"
    Then user selects new list and ensure product is added by "<Sucess Msg>"

    Examples: 
      | Search Box | Product                           | New Wishlist Name | Sucess Msg    | List Created                       |
      | Frame      | Today is a good day Framed poster | My Frames         | Product added | The list has been properly created |

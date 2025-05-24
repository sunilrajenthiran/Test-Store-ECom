Feature: Add products to cart

  Scenario Outline: Add Products to cart sucessfully
    Given user is on Home page and select "<Products>"  and "<Item>" from menu
    When user selects "<Filter>" from sort by
    Then user clicks the "<ProductName>" and Ensure correct page
    Then user selects "<Size>" "<PaperType>" and "<Quantity>"
    And user clicks Addtocart button and should be updated as "<QtyCount>"

    Examples: 
      | Products | Item | Filter             | ProductName                 | Size | PaperType | Quantity | QtyCount |
      | Clothes  | Men  | Price, high to low | Hummingbird printed t-shirt | XL   | -         |        5 |        5 |

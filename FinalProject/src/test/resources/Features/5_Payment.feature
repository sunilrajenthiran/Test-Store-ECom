Feature: Place the order

  Scenario Outline: Place the order Sucessfully
    Given user clicks Cart icon and clicks proceed to Checkout
    Then user enters Address info "<Alias>" "<FirstName>" "<LastName>" "<Company>" "<Address>" "<AddressComplement>"
    Then user enters "<City>" "<State>" "<Zip>" "<Country>" "<PhoneNumber>" and clicks continue
    And user on Shipping Method page and Add comment if needed "<Comment>"
    And user selects "<Payment Method>" and read Terms & conditions then clicks checkbox
    When user clicks Place order button order must placed

    Examples: 
      | Alias | FirstName | LastName | Company | Address | AddressComplement | City         | State  | Zip   | Country       | PhoneNumber | Comment         | Payment Method   |
      | Sunil | Sunil     | R        | Integra | 22 W St | Near Post Office  | Central City | Alaska | 98763 | United States |  9876543210 | Please Be Quick | Pay by bank wire |


# Test Store E-Commerce Website Testing
## Project Description:

Test Store E-commerce Website Testing is an end-to-end automated testing project for a sample e-commerce platform (Test Store). This project is built as a comprehensive test automation suite to validate the core functionalities of the website, ensuring a seamless user experience across various components like product search, cart management, checkout, and user login.

The framework is developed using Java and incorporates Selenium, TestNG, and Cucumber, following the Page Object Model (POM) design pattern. It is structured as a Hybrid Framework, combining the strengths of data-driven, keyword-driven, and behavior-driven testing approaches.

Additionally, Selenium Grid is integrated into the framework to enable parallel execution across multiple machines and browsers, enhancing the scalability and efficiency of test runs.

### Link : https://teststore.automationtesting.co.uk/index.php






## Technologies Used
- Java

- Selenium WebDriver

- TestNG

- Cucumber (BDD)

- Page Object Model (POM)

- Selenium Grid

- Jenkins (CI/CD)

- Maven (Build Management)

- Git & GitHub (Version Control)
## Features
Key features include:

✅ End-to-end test scenarios using Selenium WebDriver

🌐 Parallel test execution using Selenium Grid

🧪 BDD implementation with Cucumber for readable and maintainable test cases

🧱 Modular Page Object Model for code reusability

🔄 Continuous Integration with Jenkins

📂 Source code and test scripts maintained in GitHub
## Project Structure
```xml
Test-Store-ECom/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.mystore.FinalProject/
│   │           ├── Base/
│   │           │   └── BaseClass.java  # WebDriver setup (BaseClass.java)
│   │           └── Pages/              # Page classes using POM
│   │               ├── CartPage.java
│   │               ├── LoginPage.java
│   │               ├── PaymentPage.java
│   │               ├── SignUpPage.java
│   │               └── WishlistPage.java
│   └── resources/
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com.mystore.FinalProject/
│       │       ├── Runners/
│       │       │   └── TestRunner.java   # Runs tests via TestNG+Cucumber
│       │       └── StepDefinition/       # Step definitions for feature files
│       │           ├── CartStep.java
│       │           ├── LoginStep.java
│       │           ├── PaymentStep.java
│       │           ├── SignUpStep.java
│       │           └── WishlistStep.java
│       └── resources/
│           └── Features/                 # Gherkin feature files  
│               ├── 1_SignUp.feature
│               ├── 2_Login.feature
│               ├── 3_AddToCart.feature
│               ├── 4_Wishlist.feature
│               └── 5_Payment.feature
│
├── pom.xml                               # Maven dependencies & build plugins
├── testng.xml                            #TestNG suite configuration
├── target/
├── test-output                           # TestNG output report
└── README.md
```

## Test Scenarios:
- ### S1: Sign Up
  
  T1: Sign Up with valid Name, Email, Password, DOB
  
  T2: Sign Up with invalid DOB format and same Email
  
  T3: Verify the Show or Hide button in Password

- ### S2: Login
  
  T1: Login using valid credentials then logout
  
  T2: Login using invalid credentials should fail
  
  T3: Verify that the password is hidden after typed and shown after the "Show" button is clicked

- ### S3: Add to Cart
  
  T1: Verify that the click on the product opens its page
  
  T2: Verify that the add to cart button opens the 'product added' frame
  
  T3: Verify that the 'quick view' button opens the product frame

  T4: Verify the Wishlist icon by creating new
  
  T5: Verify that the 'continue shopping' button leaves the user on the same page
  
  T5: Verify that the search function leaves the user on the search page

- ### S4: Product details and cart

  T1: Verify that the cart page contains the correct product information after changing variant, quantity and proceeding to checkout

  T2: Verify that the promo code 20OFF gives 20% discount on the cart page

- ### S5: Search functionality

  T1: Verify that the sort filter 'by name A-Z' sort the searched product list alphabetically

  T2: 'by name Z-A' sort the searched product list in reverse alphabetical order

  T3: 'by price low to high' sort the searched product list in ascending price order

  T4: 'by price high to low' sort the searched product list in descending price order

- ### S6: Payment Process  

  T1: Verify the Proceed to checkout button opens the Personal information page

  T2: Verify Address with invalid Postal code

  T3: Verify the Place Order button shows the confirmation message
 
## Jenkins

### 🔄 CI/CD Integration

- Jenkins is integrated to trigger automated test executions upon code push or schedule.

- Supports test reports and notifications through Jenkins pipelines.

![Test_Result](https://github.com/user-attachments/assets/bb5fd3d8-d996-4a4a-83e2-121eacaa04c7)
![Test_History](https://github.com/user-attachments/assets/fb4732b4-a807-4995-900d-a9a935381f9e)

## Screenshots

![Home](https://github.com/user-attachments/assets/2e7f5a66-8ac5-478f-aa8c-506a3b385665)
![Products](https://github.com/user-attachments/assets/e42583eb-93ae-49a6-a2bf-93ba79af330d)
![Prod_Details](https://github.com/user-attachments/assets/41fd46e7-1cea-440b-9f2f-ac0217e00770)
![Cart](https://github.com/user-attachments/assets/cf48392c-9a8f-445d-a865-e04cfe3b8d36)
![Payment](https://github.com/user-attachments/assets/3e7dc977-bf87-4aca-bb3c-76f459c6a946)
![Order](https://github.com/user-attachments/assets/6cce085c-b692-4195-b7cd-8c4e7d2b7396)



## Contact

### Email : sunilrajendhran@gmail.com

### LinkedIn : https://www.linkedin.com/in/sunil-r-a70040314
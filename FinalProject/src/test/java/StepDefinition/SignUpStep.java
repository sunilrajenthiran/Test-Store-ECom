package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import Pages.SignUpPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStep extends BaseClass{

	
	SignUpPage signUpPage;
	
	@Before
	public void BeforeScenario() {
		setup();
		signUpPage = new SignUpPage(driver);
	}

	@Given("user is on the signup page")
	public void user_is_on_the_signup_page() {
		
		driver.get("https://teststore.automationtesting.co.uk/index.php");
		signUpPage.SignupPage();
	}

	@When("user select {string} and enters {string} and {string}")
	public void user_select_and_enters_and(String Gender, String Fname, String Lname) {
		
		signUpPage.UserName(Gender, Fname, Lname);

	}

	@When("user enters {string} {string} and {string}")
	public void user_enters_and(String Email, String Password, String BirthDay) {
		
		signUpPage.EmailandPass(Email, Password, BirthDay);
 
	}

	@Then("user selects tick boxes")
	public void user_selects_tick_boxes() {
		
		signUpPage.SelectCheckBox();
	    
	}

	@Then("clicks on Save button")
	public void clicks_on_save_button() {
		
		signUpPage.Submitbtn();
		

	}

	@Then("user should be registered sucessfully as {string}")
	public void user_should_be_registered_sucessfully(String expected) {
		
		String actual = signUpPage.VerifySignUp();
		Assert.assertEquals(actual, expected);
		System.out.println("Sucessfully Signed Up!");
//		if(signUpPage.VerifySignUp()) {
//			System.out.println("Sucessfully Signed Up!");
//		}
//		else {
//			System.out.println("Invalid SignUp!");
//		}
		
	    
	}
	

}

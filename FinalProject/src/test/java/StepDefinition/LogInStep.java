package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import Pages.LogInPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStep extends BaseClass{
	
	LogInPage loginPage;
	@Before
	public void BeforeScenario() {
		setup();
		loginPage = new LogInPage(driver);
	}
	
	@Given("user is on Login Page must Signout before Login")
	public void userIsOnLoginPageMustSignoutBeforeLogin() {
		//driver.get("https://teststore.automationtesting.co.uk/index.php");
		loginPage.SignOut();
	    
	}
	@When("user enters {string} and {string}")
	public void userEntersAnd(String Email, String Password) {
		loginPage.SignIn(Email, Password);
	    
	}
	@When("user clicks on Sign button")
	public void userClicksOnSignButton() {
		loginPage.Submit();
	    
	}
	@Then("user should be Loggedin sucessfully by {string}")
	public void userShouldBeLoggedinSucessfully(String Name) {
		
		String actual = loginPage.VerifyLogin();
		Assert.assertEquals(actual, Name);
		System.out.println("Login Sucessfully");
//		if(loginPage.VerifyLogin(Name)) {
//			System.out.println("Login Sucessfully");
//		}
//		else {
//			System.out.println("Invalid Login!");
//		}
	    
	}

}

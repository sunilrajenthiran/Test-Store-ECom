   package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import Pages.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStep extends BaseClass {
	CartPage cartPage;
	@Before
	public void BeforeScenario() {
		setup();
		cartPage = new CartPage(driver);
	}

	@Given("user is on Home page and select {string}  and {string} from menu")
	public void Category(String CatTitle, String CategoryType) throws InterruptedException  {
		//driver.get("https://teststore.automationtesting.co.uk/index.php");
		cartPage.ChooseCatogory(CatTitle, CategoryType);
	    
	}

	@When("user selects {string} from sort by")
	public void user_selects_from_sort_by(String FiterName) {
		cartPage.AddFilter(FiterName);
	  
	    
	}

	@Then("user clicks the {string} and Ensure correct page")
	public void ChooseProducts(String ProductName) {
		cartPage.ChooseProduct(ProductName);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, ProductName);
		System.out.println("Correct Product");
	    
	}

	@Then("user selects {string} {string} and {string}")
	public void ProductOption(String Size, String PaperType, String Quantity) {
		cartPage.ProductOptions(Size, PaperType, Quantity);
	    
	}

	@Then("user clicks Addtocart button and should be updated as {string}")
	public void user_clicks_addtocart_button_and_should_be_updated(String QtyCount) {
		int actualCount = cartPage.AddtoCart();
		int expectedCount = Integer.parseInt(QtyCount);
		
		Assert.assertEquals(actualCount, expectedCount, "Count does not Match");
		
		System.out.println("Product Added Sucessfully!");
	    
	}

}

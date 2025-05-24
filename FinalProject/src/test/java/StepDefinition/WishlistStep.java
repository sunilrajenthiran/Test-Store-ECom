package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import Pages.WishlistPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStep extends BaseClass {
	
	WishlistPage wishlistPage;
	
	@Before
	public void beforeScenario() {
		setup();
		wishlistPage = new WishlistPage(driver);
		
	}
	
	@Given("user search for the product using {string}")
	public void user_search_for_the_product_using(String keyWord) {
		wishlistPage.SearchforProduct(keyWord);
	    
	}

	@When("user selects desired {string} from search list")
	public void user_selects_desired_from_search_list(String ProductName) {
		wishlistPage.DesiredProduct(ProductName);
	    
	}

	@When("user clicks Wishlist icon selects default list")
	public void user_clicks_wishlist_icon_selects_default_list() {
		wishlistPage.AddtoMyWishlist();
	    
	}

	@Then("user ensure product is added by {string}")
	public void user_ensure_product_is_added(String Expected) {
		String Actual = wishlistPage.EnsureWishlist();
		Assert.assertEquals(Actual, Expected);
		System.out.println("Product Added to MyWishlit");
	    
	}

	@Given("user clicks Wishlist icon selects Create New List and add {string} to create and ensure as {string}")
	public void NewWishlist(String wishListName, String Expected) {
		String newWishlistName = wishlistPage.NewWishlist(wishListName);
		Assert.assertEquals(newWishlistName, Expected);
		System.out.println("New WishList created sucessfully!!");
	    
	}

	@Then("user selects new list and ensure product is added by {string}")
	public void user_selects_new_list_and_ensure_product_is_added(String Expected) {
		String Actual = wishlistPage.EnsureNewWishlist();
		Assert.assertEquals(Actual, Expected);
		System.out.println("Product Added to NewMyWishlit");
	    
	}

}

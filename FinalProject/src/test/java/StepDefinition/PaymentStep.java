package StepDefinition;

import Base.BaseClass;
import Pages.PaymentPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentStep extends BaseClass {
	
	PaymentPage paymentpage;
	@Before
	public void beforeScenario() {
		setup();
		paymentpage = new PaymentPage(driver);
	}
	
	
	@Given("user clicks Cart icon and clicks proceed to Checkout")
	public void user_clicks_cart_icon_and_clicks_proceed_to_checkout() {
		
		paymentpage.CheckOut();
	   
	}

	@Then("user enters Address info {string} {string} {string} {string} {string} {string}")
	public void user_enters_address_info(String Alias, String FirstName, String LastName, String Company, String Address1, String Address2) {
	   
		paymentpage.AddressInfo1(Alias, FirstName, LastName, Company, Address1, Address2);
	}

	@Then("user enters {string} {string} {string} {string} {string} and clicks continue")
	public void user_enters_and_clicks_continue(String City, String State, String Zip, String Country, String Phonenum) {
		paymentpage.AddressInfo2(City, State, Zip, Country, Phonenum);
		paymentpage.ConfirmAdd();
	}

	@Then("user on Shipping Method page and Add comment if needed {string}")
	public void user_on_shipping_method_page_and_add_comment_if_needed(String Comment) {
		paymentpage.DeliveryOption(Comment);
	   
	}

	@Then("user selects {string} and read Terms & conditions then clicks checkbox")
	public void user_selects_and_read_terms_conditions_then_clicks_checkbox(String PaymentMethod) {
		paymentpage.PaymentOption(PaymentMethod);
	   
	}

	@When("user clicks Place order button order must placed")
	public void user_clicks_place_order_button_order_must_placed() {
	   
		paymentpage.PlaceOrder();
	}


}

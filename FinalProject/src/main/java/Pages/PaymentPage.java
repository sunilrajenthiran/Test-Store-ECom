package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	@FindBy(css = ".blockcart.cart-preview.active")
	WebElement Cart;
	
	@FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
	WebElement Checkout;
	
	@FindBy(css = "#field-alias")
	WebElement alies;
	
	@FindBy(css = "#field-firstname")
	WebElement Fname;
	
	@FindBy(css = "#field-lastname")
	WebElement Lname;
	
	@FindBy(css = "#field-company")
	WebElement company;
	
	@FindBy(css = "#field-address1")
	WebElement address1;
	
	@FindBy(css = "#field-address2")
	WebElement address2;
	
	@FindBy(css = "#field-city")
	WebElement city;
	
	@FindBy(css = "#field-id_state")
	WebElement state;
	
	@FindBy(css = "#field-postcode")
	WebElement zip;
	
	@FindBy(css = "#field-id_country")
	WebElement country;
	
	@FindBy(css = "#field-phone")
	WebElement phoneNum;
	
	
	@FindBy(xpath = "//button[@name='confirm-addresses']")
	WebElement ConfirmAddress;
	
	
	
	public void CheckOut() {
		Cart.click();
		Checkout.click();
		
	}
	
	public void AddressInfo1(String Alias, String FirstName, String LastName, String Company, String Address1, String Address2) {
		alies.sendKeys(Alias);
		
//		String FName = Fname.getText();
//		String LName = Lname.getText();
//		
//		Assert.assertEquals(FName, FirstName);
//		Assert.assertEquals(LName, LastName);
		
		company.sendKeys(Company);
		address1.sendKeys(Address1);
		address2.sendKeys(Address2);	
	}
	
	public void AddressInfo2(String City, String State, String Zip, String Country, String Phonenum) {
		city.sendKeys(City);
		Select select = new Select(state);
		select.selectByVisibleText(State);
		zip.sendKeys(Zip);
		Select select1 = new Select(country);
		select1.selectByVisibleText(Country);
		phoneNum.sendKeys(Phonenum);
		
		
	}
	
	public void ConfirmAdd() {
		ConfirmAddress.click();
	}
	
	@FindBy(css = "#delivery_message")
	WebElement comment;
	
	@FindBy(css = "button[name=\"confirmDeliveryOption\"]")
	WebElement ConfirmDevOption;
	
	public void DeliveryOption(String CommentMsg) {
		comment.sendKeys(CommentMsg);
		ConfirmDevOption.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Pay by bank wire']")
	WebElement bank;
	
	@FindBy(xpath = "//span[normalize-space()='Pay by Check']")
	WebElement cheque;
	
	@FindBy(xpath = "//a[@id='cta-terms-and-conditions-0']")
	WebElement termsconbtn;
	
	@FindBy(xpath = "//input[contains(@id,'conditions_to_approve')]")
	WebElement checkBox;
	
	@FindBy(xpath = "(//button[@class='close']//span) [2]")
	WebElement close;
	
	@FindBy(xpath = "//div[@class='js-modal-content']")
	WebElement termscon;
	
	public void PaymentOption(String PaymentMethod) {
		if(PaymentMethod.equalsIgnoreCase("Pay by Check")) {
			cheque.click();
		}
		else {
			bank.click();
		}
		
		termsconbtn.click();
		wait.until(ExpectedConditions.visibilityOf(termscon));
		close.click();
		checkBox.click();
	}
	
	@FindBy(xpath = "//button[normalize-space()='Place order']")
	WebElement placeOrder;
	
	@FindBy(xpath = "//h3[@class='h1 card-title']")
	WebElement confirmOrder;
	
	public void PlaceOrder() {
		placeOrder.click();
		wait.until(ExpectedConditions.visibilityOf(confirmOrder));
		String OrderMsg = confirmOrder.getText();
		System.out.println(OrderMsg);
		if(OrderMsg.contains("YOUR ORDER IS CONFIRMED")) {
			System.out.println("Order Placed Sucessfully!");
		}
		

	}
}

 package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {

	WebDriver driver;
	WebDriverWait wait;
	String WishListName;
	public WishlistPage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(css = "input[placeholder='Search our catalog']")
	WebElement searchBox;
	
	@FindBy(css = "span[class='product']")
	List<WebElement> productList;
	
	@FindBy(css = "#ui-id-1")
	WebElement dropDown;
	
	
	public void SearchforProduct(String keyWord) {
		searchBox.sendKeys(keyWord);
		wait.until(ExpectedConditions.visibilityOf(dropDown));
	}
	
	public void DesiredProduct(String productName) {
		WebElement product = productList.stream().filter
				(prod -> prod.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		product.click();
	}
	
	@FindBy(xpath = "//button[@class='wishlist-button-add wishlist-button-product']")
	WebElement wishListIcon;
	
	@FindBy(css = ".wishlist-list-item")
	WebElement MyWishlist;
	
	@FindBy(css = ".wishlist-toast.success")
	WebElement toastMessage;
	
	public void AddtoMyWishlist() {
		wait.until(ExpectedConditions.visibilityOf(wishListIcon));
		wishListIcon.click();
		MyWishlist.click();
	}
	
	public String EnsureWishlist() {
		wait.until(ExpectedConditions.visibilityOf(toastMessage));
		String text = toastMessage.getText();
		return text;
	}
	
	@FindBy(xpath = "//a[@class='wishlist-add-to-new text-primary']")
	WebElement newWishlist;
	
	@FindBy(css = "input[placeholder=\"Add name\"]")
	WebElement addName;
	
	@FindBy(xpath = "//button[normalize-space()='Create wishlist']")
	WebElement createButton;
	
	public String NewWishlist(String wishlistName) {
		wait.until(ExpectedConditions.visibilityOf(wishListIcon));
		wishListIcon.click();
		newWishlist.click();
		WishListName=wishlistName;
		addName.sendKeys(WishListName);
		createButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(toastMessage));
		String text = toastMessage.getText();
		wait.until(ExpectedConditions.invisibilityOf(toastMessage));
		return text;	
	}
	
	
	
	public String EnsureNewWishlist() {
		
		String dyxpath = "//p[normalize-space()='"+WishListName+"']";
		driver.findElement(By.xpath(dyxpath)).click();
		wait.until(ExpectedConditions.visibilityOf(toastMessage));
		String text = toastMessage.getText();
		return text;
	}

}

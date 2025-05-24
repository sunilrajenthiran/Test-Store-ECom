package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	By accessories = By.xpath("//li[@id='category-6'] //a[@class='dropdown-item']");
	By stationery = By.xpath("//li[@id='category-7'] //a[@class=\"dropdown-item dropdown-submenu\"]");

	@FindBy(xpath = "//button[@aria-label='Sort by selection']")
	WebElement FilterDropdown;

	@FindBy(xpath = "//a[normalize-space()='Name, A to Z']")
	WebElement AtoZ;

	@FindBy(xpath = "//ul[@class='top-menu']//li")
	List<WebElement> Categories;

	@FindBy(xpath = "//a[@class='dropdown-item dropdown-submenu']")
	List<WebElement> Sections;

	@FindBy(xpath = "//a[@class='select-list js-search-link']")
	List<WebElement> Filters;

	@FindBy(css = ".h3.product-title")
	List<WebElement> Products;

	By SelectedFilter = By.xpath("//button[@aria-label='Sort by selection']");
	By loading = By.xpath("//div[@class='faceted-overlay']");
	
	@FindBy(css = "#top_sub_menu_39164")
	WebElement TopMenu;
	
	public void ChooseCatogory(String CatTitle, String CategoryType) throws InterruptedException {

		Actions a = new Actions(driver);

		boolean categoryFound = false;

		for (WebElement Category : Categories) {

		    if (Category.getText().equalsIgnoreCase(CatTitle)) {
		        categoryFound = true;
		        a.moveToElement(Category).build().perform();

		        if (!Sections.isEmpty()) {
		            boolean sectionFound = false;

		            for (WebElement section : Sections) {
		                if (section.getText().equalsIgnoreCase(CategoryType)) {
		                    sectionFound = true;
		                    a.moveToElement(section).click().build().perform();
		                    return; // exit after clicking section
		                }
		            }

		            if (!sectionFound) {
		                System.out.println("Section not found for category: " + CatTitle);
		                wait.until(ExpectedConditions.elementToBeClickable(Category));
			            System.out.println(Category);
			            Category.click();
			            return;
		            }

		        } 
		    }
		}

		// Now handle the case where no matching category was found
		if (!categoryFound) {
		    System.out.println("Invalid Category: " + CatTitle);
		}

	}

	public void AddFilter(String filtername) {
		FilterDropdown.click();

		WebElement SelectFilter = Filters.stream().filter
				(selectfilter -> selectfilter.getText().contains(filtername))
				.findFirst().orElse(null);
		SelectFilter.click();
	}
	
	
	public void ChooseProduct(String ProductName) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
		WebElement product = Products.stream().filter
				(productname -> productname.getText().equalsIgnoreCase(ProductName)).findFirst().orElse(null);
		product.click();
	}
	
	@FindBy(xpath = "//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']")
	WebElement up;
	
	@FindBy(xpath = "//div[@class='input-group bootstrap-touchspin']")
	WebElement QuantityBox;
//	
	@FindBy(xpath = "//i[@class='material-icons touchspin-down']")
	WebElement down;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement qtybox;
	
	@FindBy(xpath = "//select[@aria-label=\"Paper Type\"]")
	WebElement paperType;
	
	@FindBy(css = "#group_1")
	WebElement size;
	
	
	@FindBy(xpath = "//select[@aria-label=\"Paper Type\"]")
	List<WebElement> paperTypeList;
	
	@FindBy(css = "#group_1")
	List<WebElement> sizeList;
	
	By QuantityBox1 = By.xpath("//div[@class='input-group bootstrap-touchspin']");
	public void ProductOptions(String Size,String PaperType, String Quantity) {
		
		if(!sizeList.isEmpty() && sizeList.get(0).isDisplayed()) {
			Select s = new Select(size);
			s.selectByVisibleText(Size);
		}
		else if(!paperTypeList.isEmpty() && paperTypeList.get(0).isDisplayed()) {
			Select s = new Select(paperType);
			s.selectByVisibleText(PaperType);
		} 
		else{
			System.out.println("No Size and PapeeType is Displayed");
		}
		
		if(QuantityBox.isDisplayed()) {
			int num = Integer.parseInt(Quantity);
			for(int i=1;i<num;i++) {
				up.click();
			}
		}
		else{
			System.out.println("Not Displayed!");
		}
	}	
	
	@FindBy(css = ".btn.btn-primary.add-to-cart")
	WebElement addToCart;
	
	@FindBy(xpath = "//span[@class='cart-products-count']")
	WebElement CartIcon;
	
	@FindBy(xpath = "//button[normalize-space()='Continue shopping']")
	WebElement CntShopping;
	
	@FindBy(xpath = "//img[@alt='Test Store']")
	WebElement HomePage;
	
	public Integer AddtoCart() {
		addToCart.click();
		wait.until(ExpectedConditions.visibilityOf(CntShopping));
		CntShopping.click();
		wait.until(ExpectedConditions.visibilityOf(HomePage));
		HomePage.click();
		String cartText = CartIcon.getText();
		System.out.println(cartText);
		
		int cartCount = Integer.parseInt(cartText.replaceAll("[^0-9]", ""));
		System.out.println(cartCount);
		return cartCount;
		
	}
}

















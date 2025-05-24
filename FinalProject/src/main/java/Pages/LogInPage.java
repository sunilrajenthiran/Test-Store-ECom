package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage {

	WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='logout hidden-sm-down']")
	WebElement signOut;
	
	@FindBy(xpath = "//div[@class='user-info']")
	WebElement signinbtn;

	@FindBy(xpath = "//input[@id='field-email']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='field-password']")
	WebElement userPassword;

	@FindBy(xpath = "//button[@data-action=\"show-password\"]")
	WebElement showpw;

	@FindBy(xpath = "//button[text()='Hide']")
	WebElement hidepw;

	@FindBy(xpath = "//button[@id='submit-login']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//a[@title='View my customer account'] //span")
	WebElement userAccount;

	public void SignOut() {
		signOut.click();
	}
	public void SignIn(String email, String pass) {
		
		signinbtn.click();
		userEmail.sendKeys(email);
		
		showpw.click();
		
		userPassword.sendKeys(pass);

	}

	public void Submit() {

		hidepw.click();
		submitbtn.click();

	}

	public String VerifyLogin() {
		//String VerifyName = username;
		String UserName = userAccount.getText(); 
		//Assert.assertEquals(UserName, VerifyName);
		return UserName;
		
	}

	
}

package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage {

	WebDriver driver;
	WebDriverWait wait;
	 String FirstName;
	 String LastName;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(xpath = "//div[@class='user-info']")
	WebElement signinbtn;
	
	@FindBy(xpath = "//a[@data-link-action='display-register-form']")
	WebElement signUp;

	@FindBy(xpath = "//label[normalize-space()='Mr.']")
	WebElement male;
	
	@FindBy(xpath = "//label[normalize-space()='Mrs.']")
	WebElement female;
	
	@FindBy(css = "#field-firstname")
	WebElement firstName;
	
	@FindBy(css = "#field-lastname")
	WebElement lastName;
	
	@FindBy(css = "#field-email")
	WebElement userEmail;
	
	@FindBy(css = "#field-password")
	WebElement userPassword;

	@FindBy(xpath = "//button[normalize-space()='Show']")
	WebElement showPass;
	
	@FindBy(xpath = "//button[normalize-space()='Hide']")
	WebElement hidePass;
	
	@FindBy(css = "#field-birthday")
	WebElement birthDay;
	
	@FindBy(xpath = "//input[@name='optin']")
	WebElement Chkbox1;
	
	@FindBy(xpath = "//input[@name='psgdpr']")
	WebElement Chkbox2;
	
	@FindBy(xpath = "//input[@name='newsletter']")
	WebElement Chkbox3;
	
	@FindBy(css = "button[type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//a[@title='View my customer account'] //span")
	WebElement userAccount;
	
	public void SignupPage() {
		wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		signinbtn.click();
		signUp.click();
		
	}
	
	public void UserName(String gender, String fname, String lname) {
		if(gender.equalsIgnoreCase("Mr")){
			male.click();
		}
		else{
			female.click();
		}
		FirstName = fname;
		LastName = lname;
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
	}
    

	public void EmailandPass(String email, String password, String birthday) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		
		if(showPass.isDisplayed()) {
			showPass.click();
			hidePass.click();
		}
			
		birthDay.sendKeys(birthday);
		
	
	}
	
	public void SelectCheckBox() {
		Chkbox1.click();
		Chkbox2.click();
		Chkbox3.click();
	}
	
	public void Submitbtn() {
		submit.click();
	}
	
	public String VerifySignUp(){
		
		String UserName = userAccount.getText();
//		String VerifyName = FirstName + " " +LastName;
//        Assert.assertEquals(UserName, VerifyName);
//		System.out.println(VerifyName);
//		System.out.println(UserName);
		return UserName;

	}
}

package ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="username")
	 private WebElement userNameFiled;
	
	@FindBy(id="inputPassword")
	 private WebElement passwordFiled;
	
	@FindBy(xpath="//button[text()='Sign In']")
	 private WebElement signinBtn;
	
	@FindBy(linkText = "Forgot password?")
	 private WebElement forgotPasswordLink;
	
	@FindBy(linkText = "Create Account")
	 private WebElement createAccountlink;

	

	public WebElement getUserNameFiled() {
		return userNameFiled;
	}

	public WebElement getPasswordFiled() {
		return passwordFiled;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getCreateAccountlink() {
		return createAccountlink;
	}

	public void login(String uname,String pwd)
	{
		userNameFiled.sendKeys(uname);
		passwordFiled.sendKeys(pwd);
		signinBtn.click();
	}

}

package ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProductBtn;

	@FindBy(xpath="//div[@role='alert']")
	private WebElement confMsg;
	
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getConfMsg() {
		return confMsg ;
	}

}

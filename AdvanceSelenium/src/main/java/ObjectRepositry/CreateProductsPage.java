package ObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriverUtility;

public class CreateProductsPage {
	WebDriver driver;

	public CreateProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement AddProductbtn;
	
	public WebElement getAddProductbtn() {
		return AddProductbtn;
	}
	@FindBy(name="productName")
	private WebElement productName;
	
	@FindBy(name="productCategory")
	private WebElement productCategoryDD;
	
	@FindBy(name="quantity")
	private WebElement Quantity;
	
	@FindBy(name="price")
	private WebElement Price;
	
	@FindBy(name="vendorId")
	private WebElement vendorIdDD;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement AddBtn;
	
	public WebElement getAddBtn() {
		return AddBtn;
	}

	public WebElement productName() {
		return productName;
	}

	public WebElement getProductCategoryDD() {
		return productCategoryDD;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getPrice() {
		return Price;
	}

	public WebElement getVendorIdDD() {
		return vendorIdDD;
	}

	public void addProduct(String prodName, String quantity, String price) {
		productName.sendKeys(prodName);
		Quantity.sendKeys(quantity);
		Price.clear();
		Price.sendKeys(price);
		
	    WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(productCategoryDD, 1);
		productCategoryDD.click();
		wUtil.select(vendorIdDD, 1);
		vendorIdDD.click();
		
		AddBtn.click();
		
}
	

}

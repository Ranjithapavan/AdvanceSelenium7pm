package Champaign_Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utility.ExcelFileUtility;
import Generic_Utility.JavaUtility;
import ObjectRepositry.CreateProductsPage;
import ObjectRepositry.DashboardPage;
import ObjectRepositry.ProductsPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
//@Listeners(ListenerImp.class)
public class CreateProductTest extends BaseClass {
//	@Parameters("browser")
@Test()
//(groups= {"SmokeTest"})
	public void  addProductTest()throws IOException, InterruptedException {
	
		JavaUtility jutil=new JavaUtility();
		int randNum = jutil.getRandomNum(10000);
		
		ExcelFileUtility excelUtil=new ExcelFileUtility();
		String prodName = excelUtil.readingDataFroemExcel("ProductDetails", 1, 1)+randNum;
		String quantity = excelUtil.readingDataFroemExcel("ProductDetails", 1, 3);
		String price = excelUtil.readingDataFroemExcel("ProductDetails", 1, 4);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		Thread.sleep(2000);
		//verification of dashboard
		DashboardPage dp=new DashboardPage(driver);
		dp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getAddProductBtn().click();
		CreateProductsPage cpp=new CreateProductsPage(driver);
		cpp.addProduct(prodName, quantity, price);
		Thread.sleep(5000);
		String confMsg = pp.getConfMsg().getText();
		boolean status = confMsg.contains(prodName);
		Assert.assertTrue(status);
		}


}

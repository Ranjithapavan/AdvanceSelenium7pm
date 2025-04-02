package Champaign_Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utility.ExcelFileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.PropertiesFileUtility;
import Generic_Utility.WebDriverUtility;
import ObjectRepositry.CampaignsPage;
import ObjectRepositry.ContactsPage;
import ObjectRepositry.CreateCampaignsPage;
import ObjectRepositry.CreateContactsPage;
import ObjectRepositry.DashboardPage;
import ObjectRepositry.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CampaignContactFilling extends BaseClass {
//	@Parameters("browser")
@Test(groups= {"IntegrationTest"})
	public  void contactFillingWithCampaignTest() throws IOException, InterruptedException  {
			
		JavaUtility jutil=new JavaUtility();
		int randomNum=jutil.getRandomNum(3000);
		
		ExcelFileUtility exutil=new ExcelFileUtility();
		String Campaign = exutil.readingDataFroemExcel("DDT", 1, 2)+randomNum;
		String targetSize= exutil.readingDataFroemExcel("DDT", 1, 3);
		String organization = exutil.readingDataFroemExcel("Contact", 1, 2)+randomNum;
		String title = exutil.readingDataFroemExcel("Contact", 1, 3);
		String contactName = exutil.readingDataFroemExcel("Contact", 1, 4)+randomNum;
		String mobile = exutil.readingDataFroemExcel("Contact", 1, 5);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.create_Campaign(Campaign, targetSize);
		Thread.sleep(3000);
		
		WebElement contactLink = dp.getContactsLink();
		WebDriverUtility Wutil=new WebDriverUtility();
		Wutil.waitForElementPresent(driver, contactLink,20);
		contactLink.click();
		
		Thread.sleep(5000);
		ContactsPage ccp1=new ContactsPage(driver);
		WebElement createContactBtn = ccp1.getCreateContactBtn();
		Wutil.waitForElementPresent(driver, createContactBtn,20);
		createContactBtn.click();
		
	  CreateContactsPage cct = new CreateContactsPage(driver);
		cct.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign", "create-contact", Campaign);
		
		 Thread.sleep(5000);
       String ConfirmationMsg = ccp1.getConfMsg().getText();
       boolean status=ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true, "contactName not added");
		Reporter.log("ContactName"+contactName+"added sucessfylly",true);
	    Thread.sleep(5000);
       }

}

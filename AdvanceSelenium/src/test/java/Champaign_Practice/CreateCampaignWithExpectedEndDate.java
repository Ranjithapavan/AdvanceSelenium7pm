package Champaign_Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utility.ExcelFileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.PropertiesFileUtility;
import ObjectRepositry.CampaignsPage;
import ObjectRepositry.CreateCampaignsPage;
import ObjectRepositry.DashboardPage;
import ObjectRepositry.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
//@Listeners(ListenerImp.class)
public class CreateCampaignWithExpectedEndDateTest extends BaseClass {
//	@Parameters("browser")
	@Test(groups= {"RegressionTest"})
	public void createCampaignWithDateTest() throws InterruptedException, IOException
	{
		JavaUtility jUtil=new JavaUtility();
		int randomNum = jUtil.getRandomNum(5000);
		
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String Campaign = exUtil.readingDataFroemExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFroemExcel("DDT", 1, 3);
		
		String closeDate = jUtil.generateReqDate(30);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaignWithExpectedEndDate(Campaign, targetSize,closeDate);
		Thread.sleep(5000);
		String ConfMsg = cp.getConfMsg().getText();
		boolean status=ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "Campaign not added");
		Reporter.log("Campaign"+Campaign+"added sucessfylly",true);
		
		Thread.sleep(5000);
		}




}

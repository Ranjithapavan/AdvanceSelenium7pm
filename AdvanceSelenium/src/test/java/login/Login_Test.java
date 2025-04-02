package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utility.PropertiesFileUtility;
import ObjectRepositry.DashboardPage;
import ObjectRepositry.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class Login_Test extends BaseClass {
//	@Parameters("browser")
	@Test(retryAnalyzer =genericListenerUtility.RetryListenerImp.class )
//	(groups= {"IntegrationTest"})
	public  void loginTest() throws InterruptedException, IOException {
		PropertiesFileUtility propUtil=new PropertiesFileUtility();
	   String BROWSER = propUtil.redingDataFromPropFile("browser");
//		String BROWSER=browser;
	   String URL = propUtil.redingDataFromPropFile("url");
	   String UN = propUtil.redingDataFromPropFile("uname");
	   String PWD = propUtil.redingDataFromPropFile("pwd");
		
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		//verification of dashboard
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL,"Validation is failed");
		Reporter.log("Validation is passed",true);
		
		}

}



package genericBaseClassUtility;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generic_Utility.DataBaseUtilities;
import Generic_Utility.PropertiesFileUtility;
import ObjectRepositry.DashboardPage;
import ObjectRepositry.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	DataBaseUtilities dbutil=new DataBaseUtilities();
	PropertiesFileUtility pro=new PropertiesFileUtility();
	
	@BeforeSuite
	public void beforeSuite() 
	{
		System.out.println("Established data base connection");
		dbutil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_Selenium", "root", "Ridit@202117");
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("pre configuration set up");
	}
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		System.out.println("Launch the browser");
		String BROWSER=pro.redingDataFromPropFile("browser");
					
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
				sdriver=driver;
				}
	@BeforeMethod
	public void beforeMethod() throws IOException 
	{
		System.out.println("Login");
		   String URL = pro.redingDataFromPropFile("url");
		   String UN = pro.redingDataFromPropFile("uname");
		   String PWD = pro.redingDataFromPropFile("pwd");
		   driver.get(URL);
			LoginPage lp=new LoginPage(driver);
			lp.login(UN, PWD);
	}
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("Logout");
		DashboardPage dp=new DashboardPage(driver);
		dp.logout();
	}
	@AfterClass
	public void afterClass() 
	{
		System.out.println("Close the browser");
		driver.quit();
	}
	@AfterTest
	public void afterTest() 
	{
		System.out.println("Post configuration setup");
	}
	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("close the Database connection");
		dbutil.closeDBConnection();
	}
	
}

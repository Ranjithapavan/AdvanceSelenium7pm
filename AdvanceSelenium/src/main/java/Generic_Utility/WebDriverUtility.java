package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForElementPresent(WebDriver driver,WebElement element,long sec)
	{
		WebDriverWait wait=new WebDriverWait(  driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBEClickable(WebDriver driver,WebElement element,long sec)
	{
		WebDriverWait wait=new WebDriverWait(  driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void switchtoWindow(WebDriver driver,String partialurl)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String Window:allWindowIds)
		{
			driver.switchTo().window(Window);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("partialurl"))
			{
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver,int index)
	{
	driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String name)
	{
	driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement element )
	{
	driver.switchTo().frame(element);
	}
	public void select(WebElement element,String Value)
	{
	Select sel=new Select(element);
	sel.selectByValue(Value);
	}
	public void select(WebElement element,int index)
	{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	}
	public void select(String visibleText,WebElement element )
	{
	Select sel=new Select(element);
	sel.selectByVisibleText(visibleText);
	}
	public void actionMoveToElement(WebDriver driver,WebElement element)
	{
	Actions action =new Actions(driver);
	action.moveToElement(element).perform();;
	}
	public void actionMoveToElementAndClick(WebDriver driver,WebElement element)
	{
	Actions action =new Actions(driver);
	action.moveToElement(element).click().perform();
	}
	public void actionDoubleClick(WebDriver driver,WebElement element)
	{
	Actions action =new Actions(driver);
	action.doubleClick(element).perform();;
	}
	public void actionRightClick(WebDriver driver,WebElement element)
	{
	Actions action =new Actions(driver);
	action.contextClick(element).perform();
	}
	public void takingScreenShot(WebDriver driver,String filename) throws IOException
	{
		 TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+filename+".png");
		FileHandler.copy(temp, dest);
	 }
	public void takingScreenShotofWebelement(WebElement element,String filename) throws IOException
	{
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+filename+".png");
		FileHandler.copy(temp, dest);
	 }
	



}

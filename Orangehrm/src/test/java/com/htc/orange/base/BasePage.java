package com.htc.orange.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htc.orange.config.ConfigProperties;
import com.htc.orange.utility.MyException;
import com.htc.orange.utility.Snapshot;
import com.htc.orange.utility.WebDriverFactory;


public class BasePage extends Base
{
	
    public BasePage()  {
			fac=WebDriverFactory.getInstance();
			driver =fac.getDriver();
			wait = new WebDriverWait(driver, Base.WEBDRIVER_WAIT_TIME);
			
			prop=new ConfigProperties();
			snap=new Snapshot(driver);
			maximizeBrowser();
			
		} 
	
   
    protected void navigateToWebsite() 
    {
    	try {
			driver.get(prop.fetchPropertyFromFile("url"));
			Thread.sleep(2000);
		} catch (MyException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
    	
    }
    
   
    protected WebElement getWebElement(By locator) throws MyException
    {
    	
    	
    	try {
    		element = driver.findElement(locator);
    	}
    	catch(Exception e)
    	{
    		throw new MyException("Unable to locate the element, Please check the locator.");
    	}
    	
		return element;
    }
    
   
    
    protected List<WebElement> GetSubWebElements(By locator) throws MyException
    {
    
    	try {
    	list=driver.findElements(locator);
    	}
    	catch(Exception e)
    	{
    		throw new MyException("Unable to locate the sub elements, Please check the locator.");
    	}
    	return list;
    }
    
    
    public void clickOnUsingJs(WebElement element) {
    	executor= (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", element);
    	}
    	public void type(String text, WebElement element) {
    		
    		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    		element.clear();
    		element.sendKeys(text);
    		
    		
    	}
    
    
    protected void maximizeBrowser()
    {
    	driver.manage().window().maximize();
    }
    
   
    protected String getPageTitle() throws MyException
    {
    	
    	
    	title=driver.getTitle();
    
    	if(title==null)
    	throw new MyException("Unable to retrieve the page title");
    	
    
    	
    	return title;
    }
   
    
   protected void closeDriver()
   {
	   driver.quit();
	  
   }
  

   protected WebDriver getDriver()
   {
	   return driver;
   }
   
   
   
   protected void waitTillElementFound(By locator)
   {
	   try {
		element = getWebElement(locator);
	} catch (MyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   

   
   protected void waitTillPageLoad()
   {
	   driver.manage().timeouts().pageLoadTimeout(Base.PAGELOAD_WAIT_TIME, TimeUnit.SECONDS);
   }
   
   
   
   protected void navigateForward()
   {
	   driver.navigate().forward();
   }
    
  
    protected void navigateBack()
    {
    	driver.navigate().back();
    }
    
 
    
    protected void refresh()
    {
    	driver.navigate().refresh();
    }
   
    
    protected void clickOn(By locator) throws MyException
    {
    	element=getWebElement(locator);
    			element.click();
    		
    }
    protected void type(By locator,String value)
    {
    
		try {
			element = getWebElement(locator);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	element.sendKeys(value);
    }
    protected void typeselect(By locator,String value) throws AWTException
    {
    
		try {
			element = getWebElement(locator);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	element.sendKeys(value);
    
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} 
    
    protected boolean checkElementVisible(By locator)
    {
    	try {
			element=getWebElement(locator);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return element.isDisplayed();
    }
    

 	public void upload(By elementBy, String filename) throws MyException {
 		try {
 		File file = new File(filename);
 		driver.findElement(elementBy).sendKeys(file.getAbsolutePath());
 			Thread.sleep(2000);
 		} 
 		catch (Exception e) 
 		{
 			// TODO Auto-generated catch block
 			throw new MyException("File not present in the specified location");
 		}
 		}

    
  
    
    protected void clear(By locator)
    {
    	try {
			element=getWebElement(locator);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	element.clear();
    }
    
   
    
    protected void threadSleep()
    {
    	try {
			Thread.sleep(THREAD_SLEEP_WAIT_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected void sleep()
    {
    	try 
    	{
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
   
    
    protected void dragAndDrop(WebElement fromElement,WebElement toElement)
    {
    	Actions action=new Actions(driver);
    	action.dragAndDrop(fromElement, toElement);
    }
    
    
    
    protected void selectElementByValue(By locator,String value)
    {
    	try {
			element=getWebElement(locator);
		
    	select=new Select(element);
    	select.selectByValue(value);} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    protected void selectElementByVisibleText(By locator,String text)
    {
     try {
	     element=getWebElement(locator);

    	select=new Select(element);
    	select.selectByVisibleText(text);
      } 
     catch (MyException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
      }
    }
    
    protected void selectElementByIndex(By locator,int index)
    {
    	try {
    		element=getWebElement(locator);
    	} catch (MyException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    			
    	    	select=new Select(element);
    	select.selectByIndex(index);
    }
    
    //mouse hover
    
    protected void mouseOver(By locator)
    {
    	try {
			element=getWebElement(locator);
		
    	Actions action=new Actions(driver);
    	action.moveToElement(element).build().perform();
    	} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    protected void pressEnter()
    {
    	try {
			rob=new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
  
    
    
}

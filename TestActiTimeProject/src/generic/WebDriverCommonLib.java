package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class WebDriverCommonLib extends BaseTest {

	public void getPageTitle(String pageName)

	{
		String titleOfThePage = driver.getTitle();
		Reporter.log("The title of"+pageName+  " is " + titleOfThePage);

	}

	public void verifypageTitle(String pageName,String expectedPageTitle)
	{
		String actualPageTitle = driver.getTitle();
		if(actualPageTitle.equals(expectedPageTitle))
		{
			Reporter.log(" "+pageName+  "title is matched ",true);
		}
		else 
		{
			Reporter.log(" "+pageName+  "title is not matched ",true);
		}
	}
	public void selectTheOptionOfDropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectTheOptionOfDropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectTheOptionOfDropdown(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	public void switchToFrame(int index) 
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String nameOrId) 
	{
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebElement frameElement) 
	{
		driver.switchTo().frame(frameElement);
	}
	public void rightClick(WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.contextClick(targetElement).perform();
	}
	public void mouseHover(WebElement targetElement)
	{ 	
		Actions act = new Actions(driver);
		act.moveToElement(targetElement).perform();
	}
	public void doubleClick(WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.doubleClick(targetElement).perform();
	}
	public void dragAndDropWebElement(WebElement src,WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	public void scrollDown(int pixels)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixels+")");
	}
	public void scrollUp(int pixels)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixels)+")");
	}
	public void scrollLeft(int pixels)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(-pixels)+",0)");
	}
	public void scrollRight(int pixels)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixels+",0)");
	}
	public void scrollTillperticularWebElement(WebElement element)
	{
		Point loc = element.getLocation();
		int xaxis = loc.getX();
		int yaxis = loc.getY();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}
	public void hitEnterButton() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void generatePrintPopup() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void copy() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void paste() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void acceptAlert()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	public void dissmisJavaScriptPopup()
	{
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	public void printAllOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allOps = sel.getOptions();

		for(WebElement we:allOps)
		{
			String text = we.getText();
			System.out.println(text);
		}
	}



}


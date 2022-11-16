package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declare all the webElements present on Home page
	@FindBy(xpath="//a[text()='Create new tasks']") private WebElement createNewTaskLink;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logOutLink;
	@FindBy(xpath="//div[text()='Tasks']") private WebElement tasksTab;

	//initialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getCreateNewTaskLink() {
		return createNewTaskLink;
	}
	public WebElement getLogOutLink() {
		return logOutLink;
	}
	public WebElement getTasksTab() {
		return tasksTab;
	}

	//Logout Method
	public void logOutmethod()
	{
		logOutLink.click();
	}



}

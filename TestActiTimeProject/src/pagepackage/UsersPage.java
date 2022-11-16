package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	@FindBy(xpath="//div[text()='Users']']") private WebElement usersTab;
	@FindBy(xpath="//input[@value='Create New User']") private WebElement createNewUserbtn;

	//initialization
	public UsersPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getUsersTab() {
		return usersTab;
	}

	public WebElement getCreateNewUserbtn() {
		return createNewUserbtn;
	}

}

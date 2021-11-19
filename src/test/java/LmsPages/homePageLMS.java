package LmsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageLMS
{
	WebDriver driver ;
	
	public homePageLMS(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="txtUserLoginName")
	WebElement txt_loginName;
	
	@FindBy(id ="txtUserPassword")
	WebElement txt_password;		
	
	@FindBy(id="btnloginSubmit")
	WebElement btn_submit;
	
	@FindBy(linkText="Manage Assignments")
	WebElement link_manage_assgn;
	
	public void entercredentials()
	{
		txt_loginName.sendKeys(lmsConfig.username);
		txt_password.sendKeys(lmsConfig.password);
	}
	
	public void clicksubmit()
	{
		btn_submit.click();
	}
	
		
	public void clickmanageassgn()
	{
		link_manage_assgn.click();
	}
	
	
}

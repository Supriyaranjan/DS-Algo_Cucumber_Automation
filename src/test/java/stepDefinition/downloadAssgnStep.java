package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import LmsPages.homePageLMS;
import LmsPages.lmsConfig;
import LmsPages.lmsManageAssgnUser;
import LmsPages.loginPageLMS;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class downloadAssgnStep {

	WebDriver driver = null;
	loginPageLMS login;
	homePageLMS home;
	lmsManageAssgnUser manageassgn;
	
	@Before
	public void browsersetup()
	{
	 System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get(lmsConfig.lmsurl);
	}
	
	@After
	public void teardown()
	{
		driver.close();
		driver.quit();
		System.out.println("");
	}
	//background
	@Given("when student is active")
	public void when_student_user_is_on_lms_website() 
	{
	   	  
	 //  login = new loginPageLMS(driver);
	  // home = new homePageLMS(driver);
	   login.clicklogin();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   home.entercredentials();
	   home.clicksubmit();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
/*	@And("student_successfully_ logged_into_lms_home_page")
	public void student_successfully_logged_into_lms_home_page() 
	{
	  

	   System.out.println("Student successfully logged");
	   
	}*/

	
	/*@When("student clicks Manage assignments")
	public void student_clicks_Manage_assignments()
	{
		System.out.println("student clicks Manage assignments");
		home.clickmanageassgn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}*/
/*	@Then("student navigated to Manage Assignment user view page")
	public void student_navigated_to_manage_assignment_user_view_page() 
	{
		System.out.println("student navigated to Manage Assignment user view page");
	}*/
	//Scenario 1
	
	@Given("student is on manage assignments(.*)")
	public void student_is_on_manage_assignments_user_view() 
	{
		manageassgn.checkisonmanagepage();
	}
	
	@When("student try to edit the batch name")
	public void student_try_to_edit_the_batch_name()
	{
		manageassgn.checkbatchNamedisplayed();
	}
	
	@Then("Then_batch_name_cannot_be_edited")
	public void Then_batch_name_cannot_be_edited()
	{
		manageassgn.checkbatchNameeditable();
	}
	//scenario 2
/*	@When("student selects an (.*)")
	public void student_selects_an_assignment() 
	{
		manageassgn.AssgnnameDropselect();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}*/

	@Then("all the assignments for this batch should be displayed")
	public void all_the_assignments_for_this_batch_should_be_displayed()
	{
		manageassgn.validateAssgnnameDrop();
	}
	
	//Scenario3
	@And("assignment grades are already (.*)")
	public void assignment_grades_are_already_released() 
	{
		manageassgn.alertmsgcheck();
	}
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() 
	{
		manageassgn.alertmsgdisp();
	}
	
	
	//Scenario4
	@Then("student can view the grade")
	public void student_can_view_the_grade()
	{
		System.out.println("Student view their grade in grade tab");
	}
	
	//Scenario4
	@And("staff had added description")
	public void staff_had_added_description() 
	{
		manageassgn.validateassgndesc();
		
	}
	

	@Then("assignment description should be displayed")
	public void assignment_description_should_be_displayed() 
	{
		manageassgn.checkassgndescdisp();
	}

	//Scenario5
	@Then("assignment due date should be displayed")
	public void assignment_due_date_should_be_displayed()
	{
		manageassgn.checkassgndatedisp();
	}


@And("assignment grade is not relea(.*)")
public void assignment_grade_is_not_released() 
{
	manageassgn.alertmsgcheck();

}

//Scenario 6
@Then("download assignment link should be displayed and enabled")
public void download_assignment_link_should_be_displayed_and_enabled()
{
	manageassgn.checkdownloaddisp();
}


//Scenario 7
@And("assignment download link is enabled")
public void assignment_download_link_displayed_and_enabled() {
  manageassgn.checkdownloadenab();
}

@When("student clicks the download assignment link")
public void student_clicks_the_download_assignment_link() {
	manageassgn.downloadlinkclick();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@Then("file should get downloaded to the respective folder")
public void file_should_get_downloaded_to_the_respective_folder() 
{
	manageassgn.filedownloadcheck();
}

//Scenario 8
@Then("file should exists in destination folder")
public void file_should_exists_in_destination_folder ()
{
    
	manageassgn.isFileexists();
}



}
	
	


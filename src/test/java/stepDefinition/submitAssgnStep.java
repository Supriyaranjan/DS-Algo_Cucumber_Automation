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

public class submitAssgnStep
{

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
		System.out.println("");
	}
	
	@After
	public void teardown()
	{
		//driver.close();
		//driver.quit();
		System.out.println("");
	}
	//background
	@Given("when student is active")
	public void when_student_user_is_on_lms_website() 
	{
	   System.out.println("when student user is on lms website");
	   driver.get(lmsConfig.lmsurl);
	   login = new loginPageLMS(driver);
	   home = new homePageLMS(driver);
	   login.clicklogin();
	   home.entercredentials();
	   home.clicksubmit();
	}
	@And("student_successfully_ logged_into_lms_home_page")
	public void student_successfully_logged_into_lms_home_page() 
	{
	  

	   System.out.println("Student successfully logged");
	   
	}

	
	@When("student clicks Manage assignments")
	public void student_clicks_Manage_assignments()
	{
		System.out.println("student clicks Manage assignments");
		home.clickmanageassgn();
	}
	/*@Then("student navigated to Manage Assignment user view page")
	public void student_navigated_to_manage_assignment_user_view_page() 
	{
		System.out.println("student navigated to Manage Assignment user view page");
	}*/
	//Scenario 1
	
	@Given("student is on lms manage assignments(.*)")
	public void student_is_on_lms_manage_assignments_user_view() 
	{
		manageassgn.checkisonmanagepage();
	}
//Scenario 1		
@When("student selects an (.*)")
public void student_selects_an_assignment() {
	manageassgn.AssgnnameDropselect();
	
}

@And("assignment grade is not released")
public void this_assignment_is_not_yet_released() {
	manageassgn.alertmsgcheck();
}


@When("student clicks the upload link")
public void student_clicks_the_upload_link() {
	manageassgn.uploadfile();
}


@Then("selected file should get attached next to the upload link")
public void selected_file_should_get_attached_next_to_the_upload_link() {
	System.out.println("selected file gets attached next to the upload link");
}


@When("^student uploads assignment file")
public void student_uploads_assignment_file() {
   System.out.println("student uploads assignment file");
}


@When("student enters comments for assignment")
public void student_enters_comments_for_assignment() {
	manageassgn.entercomments();
}

@When("student clicks the submit button")
public void student_clicks_the_submit_button() {
	manageassgn.submitassgn();
}

@Then("assignment file should be uploaded and submitted successfully")
public void assignment_file_should_be_uploaded_and_submitted_successfully() {
  System.out.println("assignment file uploaded and submitted successfully");
}

@And("student has not submitted any assignment so far")
public void student_has_not_submitted_any_assignment_so_far() {
	manageassgn.alreadysubmit();
	
}

@Then("only submit button should be displayed and enabled")
public void only_submit_button_should_be_displayed_and_enabled() {
	manageassgn.enableanddisable();
}



@Then("Resubmit  button should not be displayed and enabled")
public void resubmit_button_should_not_be_displayed_and_enabled() {
   System.out.println("Resubmit  button is not  displayed and enabled");
}

@Given("student should has alteast submitted one assignment file already")
public void student_should_has_alteast_submitted_one_assignment_file_already() 
{
	manageassgn.alreadysubmit();
	
 }
@Then("Re-submit  button should be displayed and enabled")
public void re_submit_button_should_be_displayed_and_enabled() {
  
	manageassgn.enableanddisable();
}

@Then("Submit button is not displayed and enabled")
public void submit_button_is_not_displayed_and_enabled() {
  System.out.println("Submit button is not displayed and enabled");
}


@When("student clicks the Resubmit button")
public void student_clicks_the_resubmit_button() {
	manageassgn.submitassgn();
}

@Then("confirmation dialog box should be popped to confirm the resubmit")
public void confirmation_dialog_box_should_be_popped_to_confirm_the_resubmit()
{
	System.out.println("confirmation dialog box should be popped to confirm the resubmit");
}

@When("student confirms resubmit")
public void student_confirms_resubmit() {
	manageassgn.resubmitassgn();
}

@Then("assignment should be resubmitted successfully")
public void assignment_should_be_resubmitted_successfully() {
	System.out.println("assignment should be resubmitted successfully");
}

@And("previous assignments should be deleted")
public void previous_assignments_should_be_deleted()
{
	System.out.println("previous assignments should be deleted");
}

}

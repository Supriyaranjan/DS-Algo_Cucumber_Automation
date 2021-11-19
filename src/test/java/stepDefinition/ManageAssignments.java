package stepDefinition;

import static org.testng.AssertJUnit.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.Reporter;


import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageAssignments {

	WebDriver driver = null;


	@Before
	public void beforeSteps() throws InterruptedException
	{
		System.out.println("Before hook");

	/*	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
		driver = new ChromeDriver(); 

		driver.navigate().to("LMS_URL");
		Thread.sleep(3000);

		driver.manage().window().maximize();

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Selenium\\SeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get(LMS_Config.LMS_URL);
	    driver.findElement(By.id("btnLogin")).click();*/
	}

/*	@After
	public void afterSteps() {

		driver.close();
		driver.quit();
	}*/


	@Given("User is logged in as an admin or staff")
	public void user_is_logged_in_as_an_admin_or_staff() throws InterruptedException {
		System.out.println("User is logged in as an admin or staff");
		driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);

	}

	@Given("User is on manage assignments page")
	public void user_is_on_manage_assignments_page() {
		System.out.println("");
		driver.findElement(By.id("LinkManageAssign")).click();
		String title = driver.getTitle();
		AssertJUnit.assertEquals("Manage Assignment", title);
	}

	@When("User selects an assignment from the list\\/table")
	public void user_selects_an_assignment_from_the_list_table() {
		driver.findElement(By.name("Postman_1")).click();

	}

	@When("Clicks on Edit button")
	public void clicks_on_edit_button() {
		System.out.println("");
		driver.findElement(By.id("btnEditAssign")).click();
	}

	@Then("User is navigated to the Edit Assignments page")
	public void user_is_navigated_to_the_edit_assignments_page() {
		System.out.println("");
		String title = driver.getTitle();
		AssertJUnit.assertEquals("Edit Assignment", title);
	}

	@Then("That selected assignment shows up in Edit Page")
	public void that_selected_assignment_shows_up_in_edit_page() {

		boolean Validated = driver.findElement(By.name("Postman_1")).isDisplayed();

		AssertJUnit.assertTrue("Selected Assignment is not displayed for Editing",Validated);
	}

	@When("User edits the existing assignment name and submits")
	public void user_edits_the_existing_assignment_name_and_submits() {
		driver.findElement(By.id("txtAssignmentName")).sendKeys("Postman_02");
		driver.findElement(By.id("btnEditAssign")).submit();

	}

	@Then("Assignment should be updated with new assignment name")
	public void assignment_should_be_updated_with_new_assignment_name() {
		String AssignmentName = driver.findElement(By.id("txtAssignmentName")).getText();
		AssertJUnit.assertEquals("Postman_02", AssignmentName);
	}

	@When("User deletes the existing assignment name and submits")
	public void user_deletes_the_existing_assignment_name_and_submits() {
		driver.findElement(By.id("txtAssignmentName")).clear();
		driver.findElement(By.id("btnEditAssign")).submit();
	}

	@Then("There is error message for blank assignment name")
	public void there_is_error_message_for_blank_assignment_name() {
		String error_text = driver.findElement(By.id("error_message")).getText();
		AssertJUnit.assertTrue(error_text.toLowerCase().contains("blank assignment name"));

	}

	@When("User edits the existing assignment description and submits")
	public void user_edits_the_existing_assignment_description_and_submits() {
		driver.findElement(By.id("txtAssignmentDescription")).sendKeys("Attached 2 documents to study");
		driver.findElement(By.id("btnEditAssign")).submit(); 
	}

	@Then("Assignment should be updated with new assignment description")
	public void assignment_should_be_updated_with_new_assignment_description() {

		String AssignmentDescription = driver.findElement(By.id("txtAssignmentDescription")).getText();
		AssertJUnit.assertEquals("Attached 2 documents to study", AssignmentDescription);

	}

	@When("User deletes the existing assignment description and submits")
	public void user_deletes_the_existing_assignment_description_and_submits() {
		driver.findElement(By.id("txtAssignmentDescription")).clear();
		driver.findElement(By.id("btnEditAssign")).submit();

	}

	@Then("There is error message for blank assignment description")
	public void there_is_error_message_for_blank_assignment_description() {

		String error_text = driver.findElement(By.id("error_message")).getText();
		AssertJUnit.assertTrue(error_text.toLowerCase().contains("blank assignment description"));
	}

	@When("User changes the assignment due date and submits")
	public void user_changes_the_assignment_due_date_and_submits() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Assignment should be updated with new due date")
	public void assignment_should_be_updated_with_new_due_date() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("User enters a invalid_past_date")
	public void user_enters_a_invalid_past_date() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("There is error message for invalid due date")
	public void there_is_error_message_for_invalid_due_date() throws ParseException {

		System.out.println("");
		//String sDate1= driver.findElement(By.name("date")).getText();
      //  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
       // Date today = Calendar. getInstance(). getTime();
	//	if(date1.before(today) ) {

		//	String error_text = driver.findElement(By.id("error_message")).getText();
		//	AssertJUnit.assertTrue(error_text.toLowerCase().contains("past due date"));
		//}
	}

	@When("User deletes all the existing assignment file attachments and submits")
	public void user_deletes_all_the_existing_assignment_file_attachments_and_submits() {
		driver.findElement(By.id("LinkAttachment1")).clear(); // Code to remove the attachment. To be Refined when UI is available
		//		driver.findElement(By.id("LinkAttachment2")).clear();
		//		driver.findElement(By.id("LinkAttachment3")).clear();
		//		driver.findElement(By.id("LinkAttachment4")).clear();
		//		driver.findElement(By.id("LinkAttachment5")).clear();

		driver.findElement(By.id("btnEditAssign")).submit();

	}

	@Then("Assignment is updated for deleting files")
	public void assignment_is_updated_for_deleting_files() {
		boolean isDeleted = ! driver.findElement(By.id("LinkAttachment1")).isDisplayed();// Code to validate if attachment is removed. To be Refined when UI is available
		//		driver.findElement(By.id("LinkAttachment2")).isDisplayed();
		//		driver.findElement(By.id("LinkAttachment3")).isDisplayed();
		//		driver.findElement(By.id("LinkAttachment4")).isDisplayed();
		//		driver.findElement(By.id("LinkAttachment5")).isDisplayed();
		AssertJUnit.assertTrue(isDeleted);

	}

	@When("User uploads all the new assignment files and submits")
	public void user_uploads_all_the_new_assignment_files_and_submits() {
		System.out.println("5 files attached using Robot Class");

		//Code goes here
		//Implemented with TestData 
		//Test Data contains those file names
		// String TestData.file1 is a constant 

	}

	@Then("Assignment is updated with new five files")
	public void assignment_is_updated_with_new_five_files() {

		String file1 = driver.findElement(By.id("LinkAttachment1")).getText();

		//Implemented with TestData 
		//Test Data contains those file names
		// String TestData.file1 is a constant 
		// boolean	isUpdated= (TestData.file1==file1);
		//AssertJUnit.assertTrue(isUpdated);
	}


	@When("User edits assignment details and submits")
	public void user_edits_assignment_details_and_submits() {

		//Change the batch	
		System.out.println("User chooses a batch");
		//Define the Webelement first
		WebElement dropdownskills = driver.findElement(By.name("selUserBatchName"));
		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownskills);
		//SelectByVisibleText()
		dropdownvalue.selectByVisibleText("SDET 10");

		Reporter.log("Selected using VisibleText : SDET 10" );
		//Change Name
		driver.findElement(By.id("txtAssignmentName")).sendKeys("Postman_03");

		//Change Description 
		driver.findElement(By.id("txtAssignmentDescription")).sendKeys("Attached 2 documents to study");

		driver.findElement(By.id("btnEditAssign")).submit();


	}




}
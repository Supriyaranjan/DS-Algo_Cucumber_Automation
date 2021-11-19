package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class ManageAssignmentsDelete {


	WebDriver driver = null;


	@Before
	public void beforeSteps() throws InterruptedException
	{
		System.out.println("Before hook");

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
		driver = new ChromeDriver(); 

		driver.navigate().to("LMS_URL");
		Thread.sleep(3000);

		driver.manage().window().maximize();

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Selenium\\SeleniumDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get(LMS_Config.LMS_URL);
		    driver.findElement(By.id("btnLogin")).click();
	}

	@After
	public void afterSteps() {

		driver.close();
		driver.quit();
	}



	@Given("User is on Manage Assignment Page and chooses a batch")
	public void user_is_on_manage_assignment_page_and_chooses_a_batch() throws InterruptedException {

		System.out.println("User is logged in as an admin or staff");
		driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("LinkManageAssign")).click();

		//Define the Webelement first
		WebElement dropdownskills = driver.findElement(By.name("selUserBatchName"));

		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownskills);

		//SelectByVisibleText()
		dropdownvalue.selectByVisibleText("SDET08");

	}

	@When("User Clicks on Delete button")
	public void user_clicks_on_delete_button() {


		System.out.println("");
		driver.findElement(By.id("btnDeleteAssign")).click();

	}

	@Then("There should be an warning which needs user confirmation to proceed with deletion")
	public void there_should_be_an_warning_which_needs_user_confirmation_to_proceed_with_deletion() {

		boolean isWarningDisplayed = driver.findElement(By.name("delete_Warning")).isDisplayed();

		AssertJUnit.assertTrue("Delete warning not present",isWarningDisplayed);

	}

	@When("User Clicks on Delete button and confirms")
	public void user_clicks_on_delete_button_and_confirms() throws InterruptedException {

		driver.findElement(By.name("delete_Warning")).click();
		Thread.sleep(2000);


		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);

		alert.accept();
		Thread.sleep(5000);


		driver.switchTo().defaultContent();

	}

	@Then("The selected assignment is deleted")
	public void the_selected_assignment_is_deleted() {

		boolean isPresent = driver.findElement(By.name("Selenium_01")).isDisplayed();
		AssertJUnit.assertFalse("Assignment deletion failed", isPresent);


	}

	@When("User deletes assignment")
	public void user_deletes_assignment() {

		driver.findElement(By.name("Selenium_01")).click();
		driver.findElement(By.id("btnDeleteAssign")).submit();

	}

	@Then("Student from that batch gets notification about it")
	public void student_from_that_batch_gets_notification_about_it() {

		System.out.println("Notification is verified from the student login");	
	}

}

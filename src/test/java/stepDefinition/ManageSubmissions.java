package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ManageSubmissions
{
	WebDriver driver;
	@Before
	public void launchbrowser()
	{
		System.out.println("");
	/*	System.setProperty("webdriver.chrome.driver","C:\\Soniya\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();

		driver.navigate().to("LMS login page");
		driver.manage().window().maximize();*/

	}


	@Given("Admin is at the LMS Main login page")
	public void admin_is_at_the_lms_main_login_page() {
		System.out.println("User is at the login page");
	}

	@When("Admin clicks on the login button")
	public void admin_clicks_on_the_login_button() throws InterruptedException {
		System.out.println("User is at the login screen");
		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);

	
		
		
	}

	@When("Enters the login details at the login screen")
	public void enters_the_login_details_at_the_login_screen() throws InterruptedException {
		
		System.out.println("User is logged in as an admin or staff");
		driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);

		System.out.println("Login details entered");
		
	}

	@When("Admin clicks on the Submit button")
	public void admin_clicks_on_the_submit_button() {
		driver.findElement(By.id("btnLoginSubmit")).click();
		System.out.println("Hitting ths submit button");
		
	}

	@Then("Admin navigates to the Program list page")
	public void admin_navigates_to_the_program_list_page() {
		System.out.println("User is at the Programlist page");
		
	}

	/*@Given("Admin is at the Program List page")
	public void admin_is_at_the_program_list_page() {
		
	}*/

	@Given("Manage Assignments link is displayed in the page")
	public void manage_assignments_link_is_displayed_in_the_page() {
		System.out.println("Manage Assigments link is visible");
		
	}

	@When("Click on the Manage Assignments link")
	public void click_on_the_manage_assignments_link() {
		System.out.println("User clicks on the Manage Assignments link");
		
	}

	@Then("Admin navigates to the Manage Assignments page.")
	public void admin_navigates_to_the_manage_assignments_page() {
		System.out.println("Manage Assignments page is displayed");
		
	}

	/*@Given("Admin is at the Manage Assignments page")
	public void admin_is_at_the_manage_assignments_page() {
		
	}*/

	@Given("Manage button is enabled under the Assignment Grade")
	public void manage_button_is_enabled_under_the_assignment_grade() {
		System.out.println("Manage button is visible");
		
	}

	@When("Click on the Manage button")
	public void click_on_the_manage_button() {
		System.out.println("Manage buton is clicked");
		
	}

	@Then("Admin navigates to the Manage Submissions page.")
	public void admin_navigates_to_the_manage_submissions_page() {
		System.out.println("Manage Submissions page displays");
	}
}
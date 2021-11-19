package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GradeNofication {
	WebDriver driver;

	@Given("Student is at the LMS Home Page")
	public void student_is_at_the_lms_home_page() {

		System.out.println("User is at the LMS home page");



	}

	@When("Student clicks on the login button")
	public void student_clicks_on_the_login_button() throws InterruptedException {

		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);

	}

	@When("Enters the username and password")
	public void enters_the_username_and_password() throws InterruptedException {

		System.out.println("User is logged in as an admin or staff");
		driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
		Thread.sleep(3000);

	}

	@When("clicks on the Login button")
	public void clicks_on_the_login_button() {

		driver.findElement(By.id("btnLoginSubmit")).click();
	}

	@Then("LMS Home page displays")
	public void lms_home_page_displays() {
		System.out.println("LMS Home page should be displayed");


	}

	@Given("User is at the LMS Home page")
	public void user_is_at_the_lms_home_page() {

		System.out.println("User is at the LMS page");

	}

	@When("clicks on the Notification link")
	public void clicks_on_the_notification_link() {
		driver.findElement(By.linkText("Notifications")).click();


	}

	@Then("User should be able to view the Grades")
	public void user_should_be_able_to_view_the_grades() {
		System.out.println("Student should be able to view the grades");




	}

	@Then("clicks on the Grades link")
	public void clicks_on_the_grades_link() {

		driver.findElement(By.linkText("Grades")).click();
	}

	@Then("Student can view their Grades")
	public void student_can_view_their_grades() {
		System.out.println("Grades are visible");

	}




}

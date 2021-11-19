package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class manageGrades {
	WebDriver driver;
	@Before
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Soniya\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("LMS login page");
		driver.manage().window().maximize();

	}

	@After
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}


	@Given("User is on the LMS Home page")
	public void user_is_on_the_lms_home_page() throws InterruptedException {
		System.out.println("User is logged in as an admin or staff");
		driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
		Thread.sleep(3000);
		driver.findElement(By.name("btnLoginSubmit")).click();
		Thread.sleep(3000);


	}

	@Given("clicks on the Manage Assignments link")
	public void clicks_on_the_manage_assignments_link() {


		//String title = driver.getTitle();
		//AssertJUnit.assertEquals("Manage Assignment", title);
		System.out.println("pageitle");
	}

	@When("clicks on the Manage button")
	public void clicks_on_the_manage_button() {
		driver.findElement(By.id("Manage")).click();
		System.out.println("PageTitle"+ driver.getTitle());
		System.out.println("Manage Submissions page displays");


	}

	@Then("Manage Submissions page should display")
	public void manage_submissions_page_should_display() {
		System.out.println("Manage Submissions page displays");

	}

	@Given("User is on the Manage Submissions page")
	public void user_is_on_the_manage_submissions_page() {
		System.out.println("PageTitle"+ driver.getTitle());

	}

	@When("User should be able to view the {string} label")
	public void user_should_be_able_to_view_the_label(String string) {

		driver.findElement(By.name("Batch"));
		System.out.println("Batch label is present");

	}

	@When("clicks on the Batch dropdown")
	public void clicks_on_the_batch_dropdown() {

		//Validate the list of batch displays in the dropdown. 

		WebElement dropdownbatch = driver.findElement(By.id("a_batch_id"));

		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownbatch);

		//SelectByVisibleText()

		dropdownvalue.selectByVisibleText("SDET 1");
		Reporter.log("Selected using VisibleText : SDET 01 " );

	}

	@Then("All the Batch name should display in the dropdown")
	public void all_the_batch_name_should_display_in_the_dropdown() {

		System.out.println("Batch name should be displayed");
	}




	@Then("User is able to select one of the option from the dropdown")
	public void user_is_able_to_select_one_of_the_option_from_the_dropdown(WebElement ele, String value) {
		Select dropdownvalue = new Select(ele);

		List<WebElement> optionscount = dropdownvalue.getOptions();

		//using for...each loop
		for(WebElement option:optionscount)
		{
			if(option.getText().equals(value)) //Condition
			{
				option.click();
				Reporter.log("Dynamically Without Select method by using get options count : " + value);
				break;
			}

		}


	}

	@Given("Option is selected from the Batch dropdown")
	public void option_is_selected_from_the_batch_dropdown() {
		driver.findElement(By.id("a_batch_id"));

	}




	@When("User is able to view the {string} label")
	public void user_is_able_to_view_the_label(String string) {
		//using label attribute find the label name "Assignment Name"
		WebElement labelassgnname = driver.findElement(By.xpath("//label[]"));
		System.out.println(labelassgnname);



	}

	@SuppressWarnings("null")
	@When("User clicks on the Assignment Name dropdown")
	public void user_clicks_on_the_assignment_name_dropdown() {
		//Validate the list of batch name displays in the dropdown. 

		Boolean found = false;

		WebElement element = driver.findElement(By.name("a_name"));
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		for(int i=0; i<allOptions.size(); i++) {
			Object[] alloptions = null;
			if(alloptions[i].equals("your_option_text")) {
				found=true;
				break;
			}
		}
		if(found) {
			System.out.println("Value exists");
		}	  	



	}

	@SuppressWarnings("null")
	@Then("User will be able to view the options in the dropdown")
	public void user_will_be_able_to_view_the_options_in_the_dropdown() {
		//Validate the list of batch name displays in the dropdown. 

		Boolean found = false;

		WebElement element = driver.findElement(By.name("a_name"));
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		for(int i=0; i<allOptions.size(); i++) {
			Object[] alloptions = null;
			if(alloptions[i].equals("your_option_text")) {
				found=true;
				break;
			}
		}
		if(found) {
			System.out.println("Value exists");
		}	  	




	}

	@Then("to select anyone of the option from the dropdown")
	public void to_select_anyone_of_the_option_from_the_dropdown() {
		WebElement dropdownassgnname= driver.findElement(By.id("a_batch_id"));

		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownassgnname);

		//SelectByVisibleText()

		dropdownvalue.selectByVisibleText("SDET");
		System.out.println("Selected using VisibleText : SDET  " );



	}

	@Then("Date dialog box will display")
	public void date_dialog_box_will_display() {
		System.out.println("Date Dialog box should be displayed");



	}

	@Then("User should be able to select the date using the date dialog box")
	public void user_should_be_able_to_select_the_date_using_the_date_dialog_box() {


		driver.findElement(By.cssSelector("creation_time")).click();
		System.out.println("Date has been selected");


	}

	@Given("Batch, Assignment Name, Assignment Date option should be selected")
	public void batch_assignment_name_assignment_date_option_should_be_selected() {

		driver.findElement(By.id("a_id")).click();
		WebElement dropdownassgnname= driver.findElement(By.id("a_batch_id"));

		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownassgnname);

		//SelectByVisibleText()

		dropdownvalue.selectByVisibleText("SDET");
		System.out.println("Selected using VisibleText : SDET  " );


	}

	@When("Textbox of the Students field should be disabled and prepoulated")
	public void textbox_of_the_students_field_should_be_disabled_and_prepoulated() {


		Reporter.log("Student id should be displayed"+driver.findElement(By.id("sub_id")).isDisplayed());
	}

	@Then("User should not be able to update the textbox")
	public void user_should_not_be_able_to_update_the_textbox() {
		Reporter.log("Student id should be disabled"+driver.findElement(By.id("sub_id")).isEnabled());
	}


	@When("User is able to view the {string} label with a textbox")
	public void user_is_able_to_view_the_label_with_a_textbox(String string) {

		Reporter.log(" subdesc should be displayed"+driver.findElement(By.id("sub_description")).isDisplayed());
	}





	@When("Textbox of the Description field should be disabled and prepoulated")
	public void textbox_of_the_description_field_should_be_disabled_and_prepoulated() {

		Reporter.log("Subdesc should be disabled"+driver.findElement(By.id("sub_description")).isEnabled());  
	}

	@When("Textbox should be enabled")
	public void textbox_should_be_enabled() {


		Reporter.log("Subcomments section should be enabled"+driver.findElement(By.id("sub_comments")).isEnabled());

	}


	@Then("User should be able to enter the values in the textbox")
	public void user_should_be_able_to_enter_the_values_in_the_textbox() {

		driver.findElement(By.id("sub_comments")).sendKeys("good");
	}

	@Given("Batch, Assignment Name, Assignment Date option should be selected with one of the option")
	public void batch_assignment_name_assignment_date_option_should_be_selected_with_one_of_the_option1() {

		WebElement dropdownbatch = driver.findElement(By.id("a_batch_id"));

		//Inbuilt Select class
		Select dropdownvalue = new Select(dropdownbatch);

		//SelectByVisibleText()

		dropdownvalue.selectByVisibleText("SDET 1");
		WebElement dropdownassgnname= driver.findElement(By.id("a_name"));

		//Inbuilt Select class
		Select dropdownvalue1 = new Select(dropdownassgnname);

		//SelectByVisibleText()

		dropdownvalue1.selectByVisibleText("SDET 2");

	}

	@When("User should be able to view the labels {string}, {string}, {string}, {string}, {string}")
	public void user_should_be_able_to_view_the_labels(String string, String string2, String string3, String string4, String string5) {

		System.out.println("Verify the display of the labels, sub1,sub2, sub3, sub4, sub5");
	}

	@When("Uploaded files should be displayed")
	public void uploaded_files_should_be_displayed() {
		System.out.println("Files uploaded by the student should be displayed");


	}

	@Then("click the files")
	public void click_the_files() {
		driver.findElement(By.id("a_path_attach1")).click();
		driver.findElement(By.id("a_path_attach2")).click();
		driver.findElement(By.id("a_path_attach3")).click();
		driver.findElement(By.id("a_path_attach4")).click();
		driver.findElement(By.id("a_path_attach5")).click();
	}

	@Then("files should be downloaded")
	public void files_should_be_downloaded() {
		System.out.println("All the files should be downloaded in the local system ");

	}

	@When("Date field should be disabled and prepopulated with the values")
	public void date_field_should_be_disabled_and_prepopulated_with_the_values() {

		driver.findElement(By.id("a_due_date")).isDisplayed();

	}

	@Then("User should not be able to update the Subdatetime field")
	public void user_should_not_be_able_to_update_the_subdatetime_field() {

		Reporter.log("Due date filed should be diabled"+driver.findElement(By.id("a_due_date")).isEnabled());



	}
	//Grdaed by option should be displayed with the option staff or admin

	@When("Dropdown should be displayed with the option")
	public void dropdown_should_be_displayed_with_the_option() {


	}
	//User should be able to select the option

	@Then("User selects the value from the dropdown")
	public void user_selects_the_value_from_the_dropdown() {


	}
	//User preselects all the option to select the grades visible for the students

	@Then("Batch, Assignment Name, Assignment Date option should be selected with one of the options")
	public void batch_assignment_name_assignment_date_option_should_be_selected_with_one_of_the_option() {


	}

	//validates the checkbox functionality

	@When("Checkbox should be enabled")
	public void checkbox_should_be_enabled() {
		driver.findElement(By.id("checkbox")).click();;

	}



	@Then("User should be able to select the checkbox")
	public void user_should_be_able_to_select_the_checkbox() {

		System.out.println("User should be able to select the checkbox");
	}

	//User preselects all the option to select the grades visible for the students
	@Then("Batch, Assignment Name, Assignment Date, Graded By, Grade option Values are selected")
	public void batch_assignment_name_assignment_date_graded_by_grade_option_values_are_selected() {


	}

	@When("Select the {string} checkbox")
	public void select_the_checkbox(String string) {
		System.out.println("Select the checkbox");

	}

	@When("Clicks on the Submit buton")
	public void clicks_on_the_submit_buton() {

		driver.findElement(By.id("submit")).click();
	}

	@Then("{string} has to be displayed.")
	public void has_to_be_displayed(String string) {

		System.out.println("Grade has been submitted succesfully");
	}
}

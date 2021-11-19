package stepDefinition;

import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAsgnmnt{
	
	
	WebDriver driver = null;
	
	
	@Before
	public void beforevaldiation() throws InterruptedException
	{
		System.out.println("Before  hook");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Selenium\\SeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	   driver.get(LMS_Config.LMS_URL);
	    driver.findElement(By.id("btnLogin")).click();
	  /*  driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
	 	   Thread.sleep(3000);
	 	   driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
	 	   Thread.sleep(3000);
	 	   driver.findElement(By.name("btnLoginSubmit")).click();
	 	   Thread.sleep(3000);*/
	} 
	

	
	//Background
/*	 @Given("User is logged in as an admin or staff")
	    public void user_is_logged_in_as_an_admin_or_staff() throws InterruptedException {
	        System.out.println("User is logged in as an admin or staff");
	       driver.findElement(By.name("txtUserLoginName")).sendKeys(LMS_Config.LMS_Login_Name_Admin);
	 	   Thread.sleep(3000);
	 	   driver.findElement(By.name("txtUserPassword")).sendKeys(LMS_Config.LMS_Login_Password_Admin);
	 	   Thread.sleep(3000);
	 	   driver.findElement(By.name("btnLoginSubmit")).click();
	 	   Thread.sleep(3000);
	        	        
	    }*/

	   /* @And("User is on manage assignments page")
	    public void user_is_on_manage_assignments_page() {
	        System.out.println("");
	    String title = driver.getTitle();
	    AssertJUnit.assertEquals("Manage Assignment", title);
    
	    }*/
	    
	    @When("User clicks on Add assignment button")
	    public void user_clicks_on_add_assignment_button() {
	        System.out.println("");
	      driver.findElement(By.id("btnAddAssignSubmit")).click();        
	    }
	    

		@Then("Check if User is navigated to add assignments page")
	    public void check_if_user_is_navigated_to_add_assignments_page() {
	        System.out.println("");
	      String title = driver.getTitle();
	      AssertJUnit.assertEquals("Add Assignment", title);
	    }
	    
//Scenario 1
	    @When("User clicks on Batch Name dropdown")
	    public void user_clicks_on_batch_name__dropdown() {
	        // Write code here that turns the phrase above into concrete actions
	    	 System.out.println("User Clicks on Batch Name dropdown");
		       driver.findElement(By.name("selUserBatchName")).click();
		       Reporter.log("User clicks on Batch Name dropdown");
	    }
	    
	    @Then("User can view the list of batches")
	    public void user_can_view_the_list_of_batches() {
	        System.out.println("User can view the list of batches");
	    
	        String[] expectedList = {"SDET01","SDET02" ,"SDET03"};

	      List<	WebElement> list =  driver.findElements(By.name("selUserBatchName"));
	      List<String> actualList = new ArrayList<String>();
	      for(WebElement e : list){
	    	  actualList.add(e.getText());	  
	      }	      
	      AssertJUnit.assertEquals(expectedList, actualList);
	    }
	    	    
	    @And("User is able to select one batch")
	    public void user_is_able_to_select_one_batch() {
	        System.out.println("User is able to select one batch");
 
	   	driver.findElement(By.name("selUserBatchName")).isSelected();
	   	AssertJUnit.assertEquals(true, driver.findElement(By.name("selUserBatchName")).isSelected());
	        
	    }
	    
//Scenario 2	    
	    

	    @When("User chooses a batch")
	    public void user_chooses_a_batch() {
	        System.out.println("User chooses a batch");
	        //Define the Webelement first
	   	 WebElement dropdownskills = driver.findElement(By.name("selUserBatchName"));

		   	 //Inbuilt Select class
		   	 Select dropdownvalue = new Select(dropdownskills);

		   	 //SelectByVisibleText()
		   	 dropdownvalue.selectByVisibleText("SDET 02");
		   	
	    }
	    	    
	    @And("User clicks on Assignment Name")
	    public void user_clicks_on_assignment_name() {
	        System.out.println("");
	        driver.findElement(By.name("txtAssignmentName")).click();
	    }
	    
	    @Then("User is able to enter Assignment name")
	    public void user_is_able_to_enter_assignment_name() {
	        System.out.println("User is able to enter Assignment name");
	        driver.findElement(By.name("txtAssignmentName")).sendKeys("ghcg");
	       // driver.findElement(By.name("txtAssignmentName")).getText();
	      Assert.assertEquals("ghcg",driver.findElement(By.name("txtAssignmentName")).getText());
	    }    
	    
//Scenario 3	    
	    
	    @And("User clicks on Assignment Description")
	    public void user_clicks_on_assignment_description() {
	        System.out.println("");
	        driver.findElement(By.name("txtAssignmentDescription")).click();
	    }
	    
	    @Then("User is able to enter assignment Descriptions")
	    public void user_is_able_to_enter_assignment_descriptions() {
	        System.out.println("");
	        driver.findElement(By.name("txtAssignmentDescription")).sendKeys("abcd");
		      Assert.assertEquals("abcd",driver.findElement(By.name("txtAssignmentDescription")).getText());
	    }	    
	    
	    
//Scenario 4
	   @When("User Enters assignment name")
	    public void user_enters_Assignment__name() {
	    	driver.findElement(By.name("txtAssignmentName")).sendKeys("abcd");
	    	System.out.println("");
	    }
	    @And("User Enters description")
	    public void user_enters_description() {
	        System.out.println("");
	        driver.findElement(By.name("txtAssignmentDescription")).sendKeys("abcd");
	    }
	    
	    @And("User Enters date")
	    public void user_enters_date() {
	        System.out.println("");
	        driver.findElement(By.name("date")).sendKeys("10/10/2022");
	    }   
	    @And("User clicks on Submit button")
	    public void user_clicks_on_submit_button() {
	        System.out.println("");
	        driver.findElement(By.id("btnAddAssignSubmit")).click();
	    }	    
	    
	    @Then("Error message displays for blank Assignment name")
	    public void error_message_displays_for_blank_assignment_name() {
	        System.out.println("");
			String error_text = driver.findElement(By.id("error_message")).getText();
			AssertJUnit.assertTrue(error_text.toLowerCase().contains("blank assignment name"));
	    }	    
	    
//Scenario 5
	    
	    
	    @When("User Enters Assignment name")
	    public void user_enters_assignment_name() {
	        // Write code here that turns the phrase above into concrete actions
	    	System.out.println("");
	    	driver.findElement(By.name("txtAssignmentName")).sendKeys("abcd");
	    	
	    }
	    @When("User Enters Assignment description")
	    public void user_enters_assignment__description() {
	    	System.out.println("");
	    	driver.findElement(By.name("txtAssignmentDescription")).sendKeys("abcd");
	    }
	    
	    @Then("Error message displays for blank Date")
	    public void error_message_displays_for_blank_date() {
	        System.out.println("");
	        String error_text = driver.findElement(By.id("error_message")).getText();
			AssertJUnit.assertTrue(error_text.toLowerCase().contains("blank due date"));
	        
	    }    
	    
//Scenario 6
	    @And("User Selects due date in the past")
	    public void user_selects_due_date_in_the_past() {
	        System.out.println("");
	       driver.findElement(By.name("date")).sendKeys("10/10/2019");
	        
	    }
	    
	    @Then("Error message displays for past due Date")
	    public void error_message_displays_for_past_due_date() throws ParseException {
	        System.out.println("");
	        String sDate1= driver.findElement(By.name("date")).getText();
	        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
	        Date today = Calendar. getInstance(). getTime();
	        if(date1.before(today) ) {
	        	
		        String error_text = driver.findElement(By.id("error_message")).getText();
				AssertJUnit.assertTrue(error_text.toLowerCase().contains("past Due Date"));
	        }
       
	    }

//Scenario 7	 
	    
	    @And("User Selects valid Due date")
	    public void user_selects_valid_due_date() {
	        System.out.println("");
	        driver.findElement(By.name("date")).sendKeys("10/10/2020");
	        
	    }
	    
	    @And("User Uploads 1 File attachment of Size less than 5 mb")
	    public void user_uploads_1_file_attachment_of_size_less_than_5_mb() throws InterruptedException {
	        System.out.println("");
	        WebElement button = driver.findElement(By.name("LinkAttachment1"));

	   	 JavascriptExecutor js = (JavascriptExecutor) driver;
	   	 js.executeScript("arguments[0].click();",button); //Click action on the button

	   	 button.sendKeys("C:\\assignment.txt"); //Uploading the file less than 5 mb using sendKeys
	   	 System.out.println("File is Uploaded Successfully");

	   	 Thread.sleep(8000);
	    }
	    
	    @Then("Assignment will be created")
	    public void assignment_will_be_created() {
	        System.out.println("*");
	        driver.navigate().to("Manage Assignment page URL");
	        driver.findElement(By.name("abcd")).isDisplayed();
	                
	    }
	    
//Scenario 8
	    @When("User Enters assignment description")
	    public void user_enters_assignment_description() {
	    	System.out.println("");
	    	driver.findElement(By.name("txtAssignmentDescription")).sendKeys("abcd");
	    	
	    	
	    }
	    @And("User enters valid Due date")
	    public void user_enters_valid_due_date() throws InterruptedException {
	        System.out.println("");
	        driver.findElement(By.name("date")).click();
	        Thread.sleep(4000);
	        driver.findElement(By.name("date")).sendKeys("09/30/2021");
		    Thread.sleep(5000);
	        
	        
	    }
	    @And("User Uploads 5 File attachment of Size less than 5 mb")
	    public void user_uploads_5_file_attachment_of_size_less_than_5_mb() throws InterruptedException {
	        System.out.println("");
	        for(int i=1;i<6;i++) {
	        	
	        	 WebElement button = driver.findElement(By.name("LinkAttachment"+i));
	    	   	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    	   	 js.executeScript("arguments[0].click();",button); //Click action on the button

	    	   	 button.sendKeys("C:\\assignment.txt"); //Uploading the file less than 5 mb using sendKeys
	    	   	 System.out.println("Attachment"+i+" is Uploaded Successfully");
	    	   	 Thread.sleep(8000);
	        }	
	        
	    }
	    
//Scenario 9
	    	    
	    @When("Count total number of File attachment links present")
	    public void count_total_number_of_file_attachment_links_present() {
	        System.out.println("");
	      
	        int myCount = driver.findElements(By.tagName("a")).size();
	        
	    }
	    @Then("Maximum number of attachment links should be 5")
	    public void maximum_number_of_attachment_links_should_be_5() {
	        System.out.println("");
	        int assignmentCount = driver.findElements(By.tagName("a")).size();
	        AssertJUnit.assertEquals(5,assignmentCount) ;	        
	    }

//Scenario 10
	    
	    @When("User creates new assignment and submits")
	    public void user_creates_new_assignment_and_submits() {
	        System.out.println("");
		   	 WebElement dropdownskills = driver.findElement(By.name("selUserBatchName"));
		   	 Select dropdownvalue = new Select(dropdownskills);
		   	 dropdownvalue.selectByVisibleText("SDET 02"); 
	        driver.findElement(By.name("")).sendKeys("09/30/2021");
	        driver.findElement(By.name("txtAssignmentName")).sendKeys("abcd");
	        driver.findElement(By.name("txtAssignmentDescription")).sendKeys("abcd");
	        driver.findElement(By.name("date")).sendKeys("09/30/2021");
	        driver.findElement(By.name("btnAddAssignSubmit")).click();
	       
	    }	    
	/*    @Then("Student from that batch gets notification about it")
	    public void student_from_that_batch_gets_notification_about_it() {fvisible
	    
	    
	    
	        System.out.println("Student from that batch gets notification about it *");

	    }   */ 
	    
	   
}
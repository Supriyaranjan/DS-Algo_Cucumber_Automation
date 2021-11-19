package LmsPages;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lmsManageAssgnUser

{
	WebDriver driver;
	private static String downloadPath = "D:\\seleniumdownloads";
	private static String filetoupload = "C:\\assignment.txt";
	private static String comments ="using testng framework";
	
	public lmsManageAssgnUser(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(id="selUserBatchName")
	WebElement lbl_selUserBatchName;
	
	@FindBy(id="txtAssignmentName")
	WebElement dropdown_assignmentname;

	@FindBy(id="alertforassgn")
	WebElement txt_alertmsg;
	
	@FindBy(id="txtAssignmentDescription")
	WebElement txt_assignmentdesc;
	 

	@FindBy(id="txtAssignmentComment")
	WebElement txt_assignmentcomment;
	

	@FindBy(id="date")
	WebElement date;
	
	@FindBy(id="LinkAttachment1")
	WebElement downloadlink;
	
	@FindBy(id="uploadLinkAttachment1")
	WebElement file_uploadlink;
	
	@FindBy (id="btn_submit")
	WebElement btn_submitassgn;
	
	@FindBy (id="btn_resubmit")
	WebElement btn_resubmitassgn;
	
	@FindBy (id ="Aldready_submitted")
	WebElement check_alreadysubmit;
	
	public void checkisonmanagepage()
	{
		String expectedTitle ="Manage Assignments User view Page";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle);
	}
	//checking if batchname is dispalyed
	public void checkbatchNamedisplayed()
	{
		
	
		boolean batchednamedisp =lbl_selUserBatchName.isDisplayed();
		Assert.assertEquals(true, batchednamedisp);

	}
	//to validate if batchname filed is editable
	public void checkbatchNameeditable()
	{
		
	
		boolean batcheditable =lbl_selUserBatchName.isEnabled();
		Assert.assertEquals(false, batcheditable);

	}
	
	//comparing the list of assignment names in drop box with expected value
	public void AssgnnameDropselect()
	{
		Select assignmentnamelist = new Select(dropdown_assignmentname) ;
		assignmentnamelist.selectByIndex(0);
	}
	
	 public void validateAssgnnameDrop()
	 {
		 String[] expectedvalue = {"Automate Registration","Locators","data driven testing"};
		 Select assignmentnamelist = new Select(dropdown_assignmentname) ;

		 List<WebElement> assignlist = assignmentnamelist.getOptions();  
		 for(WebElement actuallist:assignlist)  
		 {  
		  boolean match = false;
		  for (int i=0; i<expectedvalue.length; i++)
		  {
		      if (actuallist.getText().equals(expectedvalue[i]))
		    		  {	  
		        match = true;
		      }
		    }
		  Assert.assertTrue(match);
		 }  
	 }
	//check if error message is displayed
	 public void alertmsgdisp()
	 {
		 
		 Assert.assertEquals("true",txt_alertmsg.isDisplayed());
		 
	 }
	 //validating the error message
	 public void alertmsgcheck()
	 {
		 String expectederrmsg ="Assignment already graded";
		 String actualerrmsg = txt_alertmsg.getAttribute("value");
		 Assert.assertEquals(expectederrmsg,actualerrmsg);
		 
	 }
	 
	
	 //validating the assignment description 
	 public void validateassgndesc()
	 {
		 String expecteddesc ="Assignment on data driven testing";
		 String actualdesc = txt_assignmentdesc.getAttribute("value");
		 Assert.assertEquals(expecteddesc,actualdesc);
		 
	 }
	 	//validating if assignment description is displayed
	 	public void checkassgndescdisp()
	 	{
		 Assert.assertEquals("true",txt_assignmentdesc.isDisplayed());
	 	};
	 
	 
	
		 //validating if assignment due date is displayed
		 public void checkassgndatedisp()
		 {
			 Assert.assertEquals("true",date.isDisplayed());
		 };
		 
		
		 
		 //validating the downloadlink is displayed	 
		 
		 public void checkdownloaddisp()
		 {
			 Assert.assertEquals(true, downloadlink.isDisplayed());
		 }
		 
		 //validating if downloadlink is enabled 
		 public void checkdownloadenab()
		 {
			 Assert.assertEquals(true, downloadlink.isEnabled());
		 }
		 
		 //clicking the download link
		 public void downloadlinkclick()
		 {
			 downloadlink.click();
		 }
		 
		 //validating if file downloaded properly
		 public void filedownloadcheck()
		 {
			 Assert.assertTrue("Failed to download Expected document",isFileDownloaded(downloadPath, "assignment.txt"));
		 }
		  
		 
		 
		 public boolean isFileDownloaded(String downloadPath, String fileName) {
				boolean flag = false;
			    File dir = new File(downloadPath);
			    File[] dir_contents = dir.listFiles();
			  	    
			    for (int i = 0; i < dir_contents.length; i++) {
			        if (dir_contents[i].getName().equals(fileName))
			            return flag=true;
			            }

			    return flag;
			}
		 
		 
		 public void isFileexists() {
			    File getLatestFile = getLatestFilefromDir(downloadPath);
			    String fileName = getLatestFile.getName();
			    Assert.assertTrue("Downloaded file name is not matching with expected file name",fileName.equals("assignment.txt") );
			}
		 
		 
		 private File getLatestFilefromDir(String dirPath){
			    File dir = new File(dirPath);
			    File[] files = dir.listFiles();
			    if (files == null || files.length == 0) {
			        return null;
			    }
			
			    File lastModifiedFile = files[0];
			    for (int i = 1; i < files.length; i++) {
			       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
			           lastModifiedFile = files[i];
			       }
			    }
			    return lastModifiedFile;
			}
			
		 public void checkuploadlinkenabled()
		 {
			 
			 Assert.assertEquals(true,file_uploadlink.isEnabled());
		 }
		 
		 public void uploadfile()
		 {
			 file_uploadlink.sendKeys(filetoupload);
		 }
		 
		 public void entercomments()
		 {
			 txt_assignmentcomment.sendKeys(comments);
		 }
		 
		 //clicking submit button
		 public void submitassgn()
		 {
			 btn_submitassgn.click();
		 }
	 
		 //validate if already submit checkbox is selected
		 public void alreadysubmit()
		 {
			 Assert.assertEquals(true,check_alreadysubmit.isSelected());
		 }
		 
		 //validate if 
		 public void enableanddisable()
		 {
			 boolean studentcheck = check_alreadysubmit.isSelected();
			 
			 if (studentcheck == true)
			 {
				Assert.assertEquals(false, btn_submitassgn.isDisplayed());
				Assert.assertEquals(true, btn_resubmitassgn.isDisplayed());
			 }
				
			 if (studentcheck == false)
			 {
				Assert.assertEquals(true, btn_submitassgn.isDisplayed());
				Assert.assertEquals(false, btn_resubmitassgn.isDisplayed());
			 }
			 
		 }
		 
		 
		//clicking resubmit button
		 public void resubmitassgn()
		 {
			 btn_resubmitassgn.click();
			 WebDriverWait w = new WebDriverWait(driver, 5);
		      //alertIsPresent() condition applied
		      if(w.until(ExpectedConditions.alertIsPresent())==null)
		      System.out.println("Alert not exists");
		      else
		      System.out.println("Alert exists");
		 }
		 
}

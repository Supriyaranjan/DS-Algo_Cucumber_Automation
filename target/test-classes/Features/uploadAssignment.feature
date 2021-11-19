Feature: To check if student is able to submit and resubmit assignment

  Background: To check if student is able to launch manage assignments
    Given when student is active
    And student successfully logged into lms home page
    When student clicks Manage assignments
    Then student is navigated to Manage Assignments user page

  Scenario: To check if student is able to upload within duedate
    Given student is on lms manage assignments user view page
    And student selects an assignment that is not yet released
    When student clicks the upload link
    Then selected file should get attached next to the upload link

 
  Scenario: To check if student is able to submit the assignment file
    Given student is on lms manage assignments user view page
    And student successfully uploaded assignment file
    And student enters comments for assignment
    When student clicks the submit button
    Then assignment file should be submitted successfully

  Scenario: To check Submit button is enabled for first time assignment upload
    Given student is on lms manage assignments user view page
    And student has not submitted any assignment so far
    When student selects an assignment that is not yet released
    Then only submit button should be displayed and enabled
    And Resubmit button should not be displayed

  Scenario: To check if Resubmit Assignment button is displayed
    Given student is on lms manage assignments user view page
    And student submitted assignment file already
    When student selects an assignment that is not yet released
    Then Resubmit button should be displayed and enabled
    And Submit button is not displayed and enabled

  Scenario: To check if student is asked to confirm for resubmit
    Given student is on lms manage assignments user view page
    And student submitted assignment file already
    And student selects an assignment that is not yet released
    And student successfully uploaded assignment file
    When student clicks the Resubmit button
  	Then assignment should be resubmitted successfully 
  	And previous assignments should be deleted

 
  

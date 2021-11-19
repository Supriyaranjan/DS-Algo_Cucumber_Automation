Feature: This feature is to check if student is able to download the assignment

  Background: To check if student is able to launch manage assignments
    Given when student is active
    And student successfully logged into lms home page
    When student clicks Manage assignments
    Then student is navigated to Manage Assignments user page

  Scenario: To check if  batch is displayed and not editable
    Given student is on manage assignments user page
    When student try to change the batch name
    Then batch name cannot be edited

  Scenario: To check if correct assignment name is displayed
    Given student is on manage assignments user page
    When student selects an assignment
    Then all the assignments for this batch should be displayed
    And student able to select an assignment

  Scenario: To check if assignment is already released
    Given student is on manage assignments user page
    When student selects an assignment
    And assignment grades are already released
    Then error message should be displayed

  Scenario: To check if assignment file is properly downloaded
    Given student is on manage assignments user view
    When student selects an assignment
    And assignment grades are already released
    Then student can view the grade 

  Scenario: To check if assignment description is displayed
    Given student is on manage assignments user page
    When student selects an assignment
    And assignment grade is not released
    And staff had added description
    Then assignment description should be displayed

  Scenario: To check if assignment due date is displayed
    Given student is on manage assignments user page
    When student selects an assignment
    And assignment grade is not released
    Then assignment due date should be displayed

  Scenario: To check if download assignment click is displayed
    Given student is on manage assignments user view
    When student selects an assignment
    And assignment grade is not released
    Then download assignment link should be displayed and enabled

  Scenario: To check if student can download assignment file
    Given student is on manage assignments user view
    And student selects an assignment
    And assignment grade is not released
    And assignment download link is enabled
    When student clicks the download assignment link
    Then file should get downloaded to the respective folder

  Scenario: To check if assignment file is properly downloaded
    Given student is on manage assignments user view
    And student selects an assignment
    And assignment grade is not released
    When student clicks the download assignment link
    Then file should exist in destination folder

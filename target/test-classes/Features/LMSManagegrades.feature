Feature: feature to test LMS Manage Grades Page

  # Same test will be executed twice with Admin details and staff details
  # Here User is mentioned as Admin and staff
  Background: User Login
    Given User is on the LMS Home page
    And clicks on the Manage Assignments link
    When clicks on the Manage button
    Then Manage Submissions page should display

  Scenario: Display of the Batch Dropdown
    Given User is on the Manage Submissions page
    When User should be able to view the "Batch" label
    And clicks on the Batch dropdown
    Then All the Batch name should display in the dropdown
    And User is able to select one of the option from the dropdown

  Scenario: Validates the Assignment Name Dropdown display
    Given User is on the Manage Submissions page
    And Option is selected from the Batch dropdown
    When User is able to view the Assignment Name label
    And User clicks on the Assignment Name dropdown
    Then User will be able to view the options in the dropdown
    And to select anyone of the option from the dropdown

  Scenario: Validates the Assignment Date Dropdown display
    Given User is on the Manage Submissions page
    When User is able to view the Assignment Date label
    And User clicks on the Assignment Date dropdown
    Then Date dialog box will display
    And User should be able to select the date using the date dialog box

  Scenario: Validate the student field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected
    When User should be able to view the Students label
    And Textbox of the Students field should be disabled and prepoulated
    Then User should not be able to update the textbox

  Scenario: Validate the Assignment description field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected
    When User is able to view the subdesc label with a textbox
    And Textbox of the Description field should be disabled and prepoulated
    Then User should not be able to update the textbox

  Scenario: Validate the Subcomments field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected
    When User should be able to view the Subcomments label
    And Textbox should be enabled
    Then User should be able to enter the values in the textbox

  Scenario: Validate the Assignment files that have been uploaded
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected with one of the option
    When User should be able to view the labels Sub1, Sub2, Sub3, Sub4, Sub5
    And Uploaded files should be displayed
    Then click the files
    And files should be downloaded

  Scenario: Validate the SubDateTime field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected with one of the option
    When User should be able to view the SubDateTime label
    And Date field should be disabled and prepopulated with the values
    Then User should not be able to update the Subdatetime field

  Scenario: Validate the Graded By field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected with one of the option
    When User should be able to view the GradedBy label
    And Dropdown should be displayed with the option
    Then User selects the value from the dropdown

  Scenario: Validate the Grade field
    Given User is on the Manage Submissions page
    And Batch, Assignment Name, Assignment Date option should be selected with one of the option
    When User should be able to view the Grade label
    And Dropdown should be displayed with the option
    Then User selects the value from the dropdown

  Scenario: Validate the Make Grades Visible checkbox
    Given: User is on the Manage Submissions page

    And Batch, Assignment Name, Assignment Date option should be selected with one of the options
    When User should be able to view the Make Grades Visible label
    And Checkbox should be enabled
    Then User should be able to select the checkbox

  Scenario: Validates the Submit button
    Given: User is on the Manage Submissions page

    And Batch, Assignment Name, Assignment Date, Graded By, Grade option Values are selected
    When Select the Make Grades Visible checkbox
    And Clicks on the Submit buton
    Then Message has to be displayed.
    #Grades has been succesfully submitted message has to be displayed

#Author: rao.rashmi
Feature: Feature to test edit assignment

  Background: 
    Given User is logged in as an admin or staff
    And User is on manage assignments page
    When User selects an assignment from the list/table
    And Clicks on Edit button
    Then User is navigated to the Edit Assignments page

  Scenario: Clicking on Edit Assignment shows the existing assignment
    Then That selected assignment shows up in Edit Page

  Scenario: Scenario to check if existing assignment name is editable
    When User edits the existing assignment name and submits
    Then Assignment should be updated with new assignment name

  Scenario: User deletes existing assignment name and submits
    When User deletes the existing assignment name and submits
    Then There is error message for blank assignment name

  Scenario: Scenario to check if existing assignment description is editable
    When User edits the existing assignment description and submits
    Then Assignment should be updated with new assignment description

  Scenario: User deletes existing assignment description and submits
    When User deletes the existing assignment description and submits
    Then There is error message for blank assignment description

  Scenario: Scenario to check if Due date is editable
    When User changes the assignment due date and submits
    Then Assignment should be updated with new due date

  Scenario: Scenario to check if past date can be selected
    When User enters a invalid_past_date
    Then There is error message for invalid due date

  Scenario: Scenario to check if the assignment file attachments can be deleted
    When User deletes all the existing assignment file attachments and submits
    Then Assignment is updated for deleting files

  Scenario: Scenario to check all the five new assignment files can be attached
    When User uploads all the new assignment files and submits
    Then Assignment is updated with new five files
    
   Scenario: To check if edit notifications are sent to students
    When User edits assignment details and submits
    Then Student from that batch gets notification about Assign Edited
    
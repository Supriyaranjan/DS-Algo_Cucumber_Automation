Feature: To test delete assignment

  Background: 
    Given User is on Manage Assignment Page and chooses a batch
    When User selects an assignment from the list/table

  #Scenario given below is an enhancement and strongly suggested
  Scenario: User clicking on delete button for assignments should give warning
    And User Clicks on Delete button
    Then There should be an warning which needs user confirmation to proceed with deletion

  Scenario: User deleting the existing assignments
    And User Clicks on Delete button and confirms
    Then The selected assignment is deleted

  Scenario: To check if delete notifications are sent to students
    When User deletes assignment
    Then Student from that batch gets notification about deletion

Feature: feature to test create Assignment

  Background: 
    Given User is logged in as an admin or staff
    And User is on manage assignments page
    When User clicks on Add assignment button
    Then Check if User is navigated to add assignments page
#1
  Scenario: User chooses batch
    When User clicks on Batch Name dropdown
    Then User can view the list of batches
    And User is able to select one batch
#2
  Scenario: User enters Assignment name
    When User chooses a batch
    And User clicks on Assignment Name
    Then User is able to enter Assignment name
#3
  Scenario: User enters assignment Description
    When User chooses a batch
    And User clicks on Assignment Description
    Then User is able to enter assignment Descriptions
#4
  Scenario: User creating assignment with blank Assignment name field
    When User chooses a batch
    And User Enters description
    And User Enters date
    And User clicks on Submit button
    Then Error message displays for blank Assignment name
#5
  Scenario: User creating assignment with blank due date
    When User chooses a batch
    And User Enters assignment name
    And User Enters Assignment description
    And User clicks on Submit button
    Then Error message displays for blank Date
#6
  Scenario: User creating assignment with past due date
    When User chooses a batch
    And User Enters Assignment name
    And User Enters Assignment description
    And User Selects due date in the past
    And User clicks on Submit button
    Then Error message displays for past due Date
#7
  Scenario: User creating assignment with 1 File Assignment Attachment
    When User chooses a batch
    And User Enters Assignment name
    And User Enters Assignment description
    And User Selects valid Due date
    And User Uploads 1 File attachment of Size less than 5 mb
    And User clicks on Submit button
    Then Assignment will be created
#8
  Scenario: User creating assignment with 5 Assignment File Attachment
    When User chooses a batch
    And User Enters Assignment name
    And User Enters Assignment description
    And User enters valid Due date
    And User Uploads 5 File attachment of Size less than 5 mb
    And User clicks on Submit button
    Then Assignment will be created
#9
  Scenario: Check maximum number of assignment that can be submitted
    When Count total number of File attachment links present
    Then Maximum number of attachment links should be 5
#10
  Scenario: To check if New assignment notifications are sent to students
    When User creates new assignment and submits
    Then Student from that batch gets notification about it

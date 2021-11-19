Feature: Navigate to the Manage Submission page

Background: Admin navigates to the Program list page
Given Admin is at the LMS Main login page
When Admin clicks on the login button
And  Enters the login details at the login screen
And  Admin clicks on the Submit button 
Then Admin navigates to the Program list page

Scenario: Admin navigates to the Manage Assignments page
Given Admin is at the Program List page
And Manage Assignments link is displayed in the page
When Click on the Manage Assignments link
Then Admin navigates to the Manage Assignments page

Scenario: Admin navigates to the Manage Submissions page
Given Admin is at the Manage Assignments page
And Manage button is enabled under the Assignment Grade 
When Click on the Manage button
Then Admin navigates to the Manage Submissions page




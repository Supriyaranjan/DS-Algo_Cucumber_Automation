Feature: To verify the Grades in the notification

#Here the user is the student
Background: Student should be able to login
Given Student is at the LMS Home Page
When Student clicks on the login button
And Enters the username and password
And clicks on the Login button
Then LMS Home page displays

Scenario: To view the notifications
Given User is at the LMS Home page
When clicks on the Notification link
Then User should be able to view the Grades 
And clicks on the Grades link
Then Student can view their Grades


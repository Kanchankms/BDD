Feature: Hotel Login Funtionality
Scenario: Username password not entered
Given User is on login page
When username password is blank
Then Display Error Message 'Please enter Username'


Scenario: password is blank
Given User is on login page
When username is given but password is blank
Then Display Error Message 'Please enter password'

Scenario: Invalid Username and password entered
Given User is on login page
When invalid username password is entered
Then Display alert 'Invalid login' 

Scenario: Valid Username and password entered
Given User is on login page
When valid username password is entered
Then Navigate to Hotel Booking page


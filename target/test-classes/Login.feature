Feature: Login function for Zoopla
#Description:
#Background:

Scenario: As a zoopla user, login should be successfull with valid credential

Given Open browser & go to zoopla URL
When try to login with credential
Then validate login was success
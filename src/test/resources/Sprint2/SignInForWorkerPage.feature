Feature: Login/Sign in Page for Worker

As a Worker PeaceOfMinde Management System
I want to sign into the system
So that I can find work

  Background: 
    Given an account with the username "username" exists in the system
    And an account with the email address "emailaddress2@gmail.com" exists in the system
    And the Worker type sign in portal is clicked

  Scenario: Log in with a valid email address and a valid password
     Given the email address "emailaddress@gmail.com" and password "password123" are entered.
     When I try to click sign in
     Then a the worker with address "emailaddress@gmail.com" dashboard is opened 
  
  Scenario: Sign in with an incorrect password
     Given the email address "emailaddress@gmail.com" and password "password456" are entered.
     When I try to click sign up
     And a message "You have entered an incorrect password!" shall be returned to the worker.
  
  Scenario: Sign in with incorrect email address
     Given the email address "emailaddress456@gmail.com" and password "password123" is entered.
     And there is no account with email address "emailaddress456@gmail.com" in the system.
     When I try to click sign up
     Then a message "There is no account associated with this account!" shall be returned to the worker
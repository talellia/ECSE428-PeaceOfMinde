Feature: Worker Account Page

 As a Worker of the PeaceOfMinde Management System
 I would like to view my account page
 So that I can see see my my past transactions and upcoming jobs 

Scenario: Access Account Page while logged in (Normal flow)
 Given the Worker is on the home page
 And the Worker is logged in
 When the Worker clicks the My Account button
 Then the Worker Account Page is displayed

Scenario: Access Account Page while logged out (Alternative flow)
 Given the Worker is on the home page
 And the Worker is logged out
 When the Worker clicks the My Account button
 Then the LoginSignup page is displayed
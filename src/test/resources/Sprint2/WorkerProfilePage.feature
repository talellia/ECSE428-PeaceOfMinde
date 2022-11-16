Feature: Worker Profile Page

 As a Worker of the PeaceOfMinde Management System
 I would like to view my profile page
 So that I can see see my personal information stored by the application

Scenario: Access Profile Page while logged in (Normal flow)
 Given the Worker is on the home page
 And the Worker is logged in
 When the Worker clicks the My Profile button
 Then the Worker Profile Page is displayed

Scenario: Access Profile Page while logged out (Alternative flow)
 Given the Worker is on the home page
 And the Worker is logged out
 When the Worker clicks the My Profile button
 Then the LoginSignup page is displayed
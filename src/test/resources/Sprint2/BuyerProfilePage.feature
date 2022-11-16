Feature: Buyer Profile Page

 As a Buyer of the PeaceOfMinde Management System
 I would like to view my profile page
 So that I can see see my personal information stored by the application

Scenario: Access Profile Page while logged in (Normal flow)
 Given the Buyer is on the home page
 And the Buyer is logged in
 When the Buyer clicks the My Profile button
 Then the Buyer Profile Page is displayed

Scenario: Access Profile Page while logged out (Alternative flow)
 Given the Buyer is on the home page
 And the Buyer is logged out
 When the Buyer clicks the My Profile button
 Then the LoginSignup page is displayed


Feature: Buyer Account Page

 As a Buyer of the PeaceOfMinde Management System
 I would like to view my account page
 So that I can see see my my past transactions and upcoming jobs 

Scenario: Access Account Page while logged in (Normal flow)
 Given the Buyer is on the home page
 And the Buyer is logged in
 When the Buyer clicks the My Account button
 Then the Buyer Account Page is displayed

Scenario: Access Account Page while logged out (Alternative flow)
 Given the Buyer is on the home page
 And the Buyer is logged out
 When the Buyer clicks the My Account button
 Then the LoginSignup page is displayed.
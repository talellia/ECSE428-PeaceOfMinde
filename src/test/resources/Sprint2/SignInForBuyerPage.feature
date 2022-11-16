Feature: Login/Sign in Page for Buyer

As a Buyer of the PeaceOfMinde Management System
I want to sign into the system
So that I can find a babysitter

  Background:
    Given the following buyers already exist in the system:
      | username | emailAddress       | password |
      | user1    | user1@gmail.com    | pass1    |
      | user2    | user2@gmail.com    | pass2    |

  Scenario Outline: Log in with a valid email address and a valid password
    Given the email address "<emailAddress>" and password "<password>" are entered
    When user tries to click sign in
    Then a the buyer with address "<emailAddress>" dashboard is opened

    Examples:
      | username | emailAddress    | password | message |
      | user1    | user1@gmail.com | pass1    | None    |
      | user2    | user2@gmail.com | pass2    | None    |

  Scenario Outline: Sign in with an incorrect password
    Given the email address "<emailAddress>" and password "<password>" are entered
    When user tries to click sign up
    And a message "<message>" shall be returned.

    Examples:
      | username | emailAddress    | password | message                                 |
      | user2    | user2@gmail.com | pass3    | You have entered an incorrect password! |


  Scenario Outline: Sign in with incorrect email address
    Given the email address "<emailAddress>" and password "<password>" is entered
    And there is no account with email address "<emailAddress>" in the system
    When user tries to click sign up
    Then a message "<message>" shall be returned.

    Examples:
      | username | emailAddress    | password | message                                           |
      | user2    | user3@gmail.com | pass2    | There is no account associated with this account! |
Feature: Change Password Page
As a user, I want to be able to
chane my password.


  Background:
    Given the following users exist in the system:
      | username | emailAddress       | password |
      | user1    | user1@gmail.com    | pass1    |
      | user2    | user2@gmail.com    | pass2    |

  Scenario Outline: Change password as logged in user successfully
    Given the user with  email address "<emailAddress>" and password "<password>" is logged in to the system
    When user tries to click change password with "<newPassword>"
    Then users new password is "<newPassword>"

    Examples:
      | username | emailAddress      | password | newPassword |
      | user1    | user1@gmail.com   | pass1    | newPass1    |


  Scenario Outline: Change password as logged in user fail
    Given the user with  email address "<emailAddress>" and password "<password>" is logged in to the system
    When user tries to click change password with "<newPassword>"
    Then a message "<message>" shall be returned to the user

    Examples:
      | username | emailAddress      | password | newPassword | message                                                |
      | user1    | user1@gmail.com   | pass1    | newPass1    | Your new password cannot be same with your old one !   |

  

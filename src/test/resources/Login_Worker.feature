Feature: Login Worker

  As a worker of the PeaceOfMinde Management System
  I would like to log into my Worker Account
  So I can take on jobs

  Scenario: Worker login with username (Normal Flow)

    Given the following Workers exist:
      | user_name         | user_email                 | user_password       | user_id |
      | Andrews_A         | Andrews_A@gmail.com        | password123!        | 123     |
      | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | 030     |
      | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | 912     |
    When a request to login worker is issued with username "Cooper_B" and password "iwuhs@028904jOIjs02"
    Then Worker with id "030" is logged in

  Scenario: Worker login with email (Alternate Flow)

    Given the following Workers exist:
      | user_name         | user_email                 | user_password       | user_id |
      | Andrews_A         | Andrews_A@gmail.com        | password123!        | 123     |
      | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | 030     |
      | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | 912     |
    When a request to login worker is issued with email "Cooper_B@gmail.com" and password "iwuhs@028904jOIjs02"
    Then Worker with id "030" is logged in

  Scenario Outline: Worker login fails (Error flow)

    Given the following Workers exist:
      | user_name         | user_email                 | user_password       | user_id |
      | Andrews_A         | Andrews_A@gmail.com        | password123!        | 123     |
      | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | 030     |
      | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | 912     |
    When a request to login worker is issued with user name <attempt_user_name> and password <attempt_password>
    Then login worker fails
    And the error message "Username or password is incorrect. Please try again" is issued to worker
    Examples:
      | attempt_user_name  | attempt_password   |
      | "Andrews_A"        | "wrongPassword233" |
      | "incorrectUserName"| "password123!"     |

Feature: Worker Sign-Up

  As a member of the general public who needs a specific service to be done,
  I would like become a Worker in the PeaceOfMinde Management System
  So that I take on jobs

  Scenario Outline: Sign up as a Worker (Normal Flow)

    Given a user wants to sign up to the PeaceOfMinde Management System as a Worker user_type
    When Worker <user_name> requests to sign up as a Worker with a unique email <user_email> and a <user_password>
    Then a new worker is generated
    Examples:
      | user_name         | user_email                 | user_password         | user_id |
      | "Andrews_A"       | "Andrews_A@gmail.com"      | "password123!"        | 123     |
      | "Cooper_B"        | "Cooper_B@gmail.com"       | "iwuhs@028904jOIjs02" | 030     |
      | "Jones_J"         | "Jones_J@gmail.com"        | "ijabnsiw@"           | 912     |


  Scenario Outline:  Sign up as a Worker with erronous information (Error Flows)

    Given a new user who inputs a username <user_name>, email <user_email>, and password <user_password>
    And there exists a worker with username "Andrews_A" and email "midway.lover@gmail.com"
    When the new user requests to requests to sign up as a Worker
    Then a message <message> is issued to worker
    And the Worker account is not created
    Examples:
      | user_name         | user_email                 | user_password         | user_id | message                      |
      | "Andrews_A"       | "midway.lover@gmail.com"   | "password123!"        | 123     | "Username already exists"    |
      | "Cooper_B"        | "midway.lover@gmail.com"   | "iwuhs@028904jOIjs02" | 030     | "Email already exists"       |
      | "Jones_J"         | "punicWars"                | "ijabnsiw@(92ns)"     | 912     | "Incorrect email format"     |
      | "Jones_J"         | "punicWars@gmail.com"      | "1"                   | 819     | "Incorrect password format"  |
      | ""                | "proper.email@gmail.com"   | "19972jISjj2oS1"      | 012     | "Username is required"       |
      | "Jones_J"         | ""                         | "ij1io91is@osla!"     | 209     | "Email is required"          |
      | "properUsername"  | "proper.email@gmail.com"   |""                     | 817     | "Password is required"       |

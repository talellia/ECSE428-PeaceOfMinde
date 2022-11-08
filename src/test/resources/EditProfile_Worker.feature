Feature: Worker Edit Profile

As a an existing worker within the PeaceOfMinde Management System,
I would like to edit my worker profile 
So that I can provide accurate information on my person and services.

    Scenario Outline: Edit profile as a worker (Normal Flow)

        Given a worker wants to edit their worker profile within the  PeaceOfMinde Management System
        When Worker "Cooper_B" requests to edit their worker profile with a unique email "hello@gmail.com" and a "hello123"
        Then the worker "hello@gmail.com" and "hello123" is updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type | availability_id |
        | Andrews_A         | Andrews_A@gmail.com        | password123!        | 123     | Worker    | 001             |
        | Andrews_B         | Andrews_A@gmail.com        | password123!        | 123     | Worker    | 001             |
        | Andrews_A         | Andrews_B@gmail.com        | password123!        | 123     | Worker    | 006             |
        | Andrews_A         | Andrews_A@gmail.com        | password!           | 123     | Worker    | 006             |        
        | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | 030     | Worker    | 002             |
        | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | 912     | Worker    | 003             |


    Scenario Outline: Edit profile as a worker with incorrect information(Error Flow)

        Given an existing worker who inputs a username "Jones_J", email "hello", and password "hello"
        And the "hello" and "hello" do not follow the correct format
        When the existing worker requests to update their profile
        Then a worker message "The worker with this email does not exist" is issued
        And the Worker account is not updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type | availability_id |message                    |
        | Jones_J           | punicWars                  | ijabnsiw@(92ns)     | 912     | Worker    | 009             |Incorrect email format     |
        | Jones_J           | punicWars@gmail.com        | 1                   | 912     | Worker    | 008             |Incorrect password format  |      

    Scenario Outline: Edit profile as a worker with an existing email and username (Error Flow)

        Given an existing worker who inputs a username "Cooper_B", email "hello@gmail.com", and password "hello123"
        And there exists a worker with username "Cooper_B" and email "hello@gmail.com" in the PeaceOfMinde Management System
        When the existing worker requests to update their profile
        Then a worker message "The worker with this email does not exist" is issued
        And the Worker account is not updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type | availability_id |message                    |
        | Jones_J           | Cooper_B@gmail.com         | ijabnsiw@(92ns)     | 912     | Worker    | 012             |Email already exists       |
        | Cooper_B          | punicWars@gmail.com        | ijabnsiw@(92ns)     | 912     | Worker    | 013             |Username already exists    |  


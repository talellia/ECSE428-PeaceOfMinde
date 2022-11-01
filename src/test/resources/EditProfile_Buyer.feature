Feature: Buyer Edit Profile

As a an existing buyer within the PeaceOfMinde Management System,
I would like to edit my buyer profile 
So that I can provide accurate information on my person and services.

    Scenario Outline: Edit profile as a buyer (Normal Flow)

        Given a buyer wants to edit their buyer profile within the  PeaceOfMinde Management System
        When a buyer "Cooper_B" requests to edit their buyer profile with a unique email "hello@gmail.com" and a "hello123"
        Then the "hello@gmail.com" and "hello123" is updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type |
        | "Andrews_A"         | "Andrews_A@gmail.com"        | "password123!"        | 123     | "Buyer"    |
        | "Andrews_B"        | "Andrews_A@gmail.com"        | "password123!"        | 123     | "Buyer"    |
        | "Andrews_A"         | "Andrews_B@gmail.com"        | "password123!"        | 123     | "Buyer"    |
        | "Andrews_A"         | "Andrews_A@gmail.com"        | "password!"           | 123     | "Buyer"    |
        | "Cooper_B"          | "Cooper_B@gmail.com"         | "iwuhs@028904jOIjs02" | 030     | "Buyer"    |
        | "Jones_J"           | "Jones_J@gmail.com"          | "ijabnsiw@"           | 912     | "Buyer"    |

    Scenario Outline: Edit profile as a buyer with incorrect information(Error Flow)

        Given an existing buyer who inputs a username "Jones_J", email "hello", and password "hello"
        And the "hello" and "hello" do not follow the correct format
        When the existing buyer requests to update their profile
        Then a message "The buyer with this email does not exist" is issued
        And the buyer account is not updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type |message                    |
        | "Jones_J"           | "punicWars"                  | "ijabnsiw@(92ns)"     | 912     | "Buyer"    |"Incorrect email format"     |
        | "Jones_J"           | "punicWars@gmail.com"        | "1"                   | 912     | "Buyer"    |"Incorrect password format"  |

    Scenario Outline: Edit profile as a buyer with an existing email and username (Error Flow)

        Given an existing buyer who inputs a username "Cooper_B", email "hello@gmail.com", and password "hello123"
        And there exists a buyer with username "Cooper_B" and email "hello@gmail.com"
        When the existing buyer requests to update their profile
        Then a message "The buyer with this email does not exist" is issued
        And the buyer account is not updated
        Examples:
        | user_name         | user_email                 | user_password       | user_id | user_type |message                    |
        | "Jones_J"           | "Cooper_B@gmail.com"         | "ijabnsiw@(92ns)"     | 912     | "Buyer"     |"Email already exists"       |
        | "Cooper_B"          | "Jones_J@gmail.com"          | "ijabnsiw@(92ns)"     | 912     | "Buyer"     |"Username already exists"    |


Feature: Buyer Change Password

As a Buyer in the PeaceOfMinde Management System
I would like to change the password of my account

    Scenario: Change Password as a Buyer (Normal Flow)

      Given the following buyers exist in the system:
        | user_name         | user_email                 | user_password       | new_password	 	 	| user_id   |
        | Andrews_A         | Andrews_A@gmail.com        | password123!        | brandnewpas$word		| 123		|
        | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | brandnewpas$word		| 130 		|
        | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | brandnewpas$word		| 445 		|
      When a request to change password is sent by buyer with unique email "Cooper_B@gmail.com" and a new password "brandnewpas$word!"
      Then the buyer with user ID "130" has a new password in the database.

    Scenario:  Change Password with same password (Error Flows)

      Given the following buyers exist in the system:
        | user_name         | user_email                 | user_password       | new_password	 	 	| user_id   |
        | Andrews_A         | Andrews_A@gmail.com        | password123!        | brandnewpas$word		| 123		|
        | Cooper_B          | Cooper_B@gmail.com         | password123!        | brandnewpas$word		| 130 		|
        | Jones_J           | Jones_J@gmail.com          | password123!        | brandnewpas$word		| 445 		|
      When a request to change password is sent by buyer with unique email "Cooper_B@gmail.com" and the same password "password123!"
      Then the password is not updated for buyer
      And the password error message "Your new password cannot be same as your new password." is issued to buyer
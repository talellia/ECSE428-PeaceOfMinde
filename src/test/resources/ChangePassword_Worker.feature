Feature: Worker Change Password

As a Worker in the PeaceOfMinde Management System
I would like to change the password of my account

    Scenario Outline: Change Password as a Worker (Normal Flow)

      Given the following workers exist:
        | user_name         | user_email                 | user_password       | new_password	 	 		| user_id   |
        | Andrews_A         | Andrews_A@gmail.com        | password123!        | brandnewpas$word		| 123				|
        | Cooper_B          | Cooper_B@gmail.com         | iwuhs@028904jOIjs02 | brandnewpas$word		| 130 			|
        | Jones_J           | Jones_J@gmail.com          | ijabnsiw@           | brandnewpas$word		| 445 			|
			When a request to change password is sent by worker with unique email "Cooper_B@gmail.com" and a new password "brandnewpas$word!"
      Then the Worker with user ID "130" has a new password in the database.

    Scenario Outline:  Change Password with same password (Error Flows)
        
			Given the following users exist:
        | user_name         | user_email                 | user_password       | new_password  | message                    |
        | Andrews_A         | midway.lover@gmail.com     | password123!        | password123!  | Password is the same!      |
        | Cooper_B          | midway.lover@gmail.com     | iwuhs@028904jOIjs02 | password678!  | Password Updated           |    
        | Jones_J           | punicWars                  | ijabnsiw@(92ns)     | 123           | Password too short         |
        | Jones_J           | punicWars@gmail.com        | 1                   | password678   | Incorrect password format  |
        |                   | proper.email@gmail.com     | 19972jISjj2oS1      | ooooo         | Username is required       |
        | Jones_J           |                            | ij1io91is@osla!     | passwerr      | Password Updated           |
        | properUsername    | proper.email@gmail.com     |                     | 2343          | Password Missing           |
      When a request to change password is sent by worker with unique email "Cooper_B@gmail.com" and the same password "password123!"
      Then the password is not updated
      And the error message "Your new password cannot be same as your new password." is issued to worker
Feature: Create Buyer About Me Section
  As a buyer, I want the Peace of Mind Application
  to add an about me section to my account.

  Scenario Outline: Valid about me section creation
    Given The buyer identified by <id> inputs a valid "<aboutMe>" description
    When An add about me section request is generated
    Then The about me description should be added to the database for the buyer

    Examples:
      | id        | aboutMe                                                           |
      | 1         | I'm looking for someone to take care of my plants while I travel. |
      | 2         | !!!                                                               |
      | 3         |                                                                   |


  Scenario Outline: Invalid about me section creation
    Given An buyer that cannot be identified by <id> inputs an "<aboutMe>" description
    When An add about me section request is generated
    Then The about me description should not be added to the database for the buyer

    Examples:
      | id        | aboutMe                                                           |
      | 5         | I'm looking for someone to take care of my plants while I travel. |

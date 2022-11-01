Feature: Create Worker About Me Section
  As a worker, I want the Peace of Mind Application
  to add an about me section to my account.

  Scenario Outline: Valid about me section creation
    Given The worker identified by <id> inputs a valid "<aboutMe>" description
    When An add about me section request is generated for the worker
    Then The about me description should be added to the database for the worker

    Examples:
      | id        | aboutMe                 |
      | 1         | I'm looking to cat-sit! |
      | 2         | !!!                     |
      | 3         |                         |


  Scenario Outline: Invalid about me section creation
    Given A worker that cannot be identified by <id> inputs an "<aboutMe>" description
    When An add about me section request is generated for the worker
    Then The about me description should not be added to the database for the worker

    Examples:
      | id        | aboutMe                 |
      | 5         | I'm looking to cat-sit! |

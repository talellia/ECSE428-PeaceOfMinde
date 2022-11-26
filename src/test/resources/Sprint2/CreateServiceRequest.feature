Feature: Create Service Request
  As a buyer, I want the Peace of Mind Application
  to create a new service request.

  Scenario Outline: Valid service request creation
    Given An existing buyer inputs a service request with "<title>", "<description>", <hourlySalary>.
    When A service request creation is generated
    Then The service request should be added to the database

    Examples:
      | title                                 | description                                                          | hourlySalary  |
      | Looking for nanny for a 3yr. old :) | I'm looking for a nanny on some weeknights so I can have some time off | 20            |
      | Take care of my plants              | Going away for two weeks and I need someone to water my plants.        | 0              |

  Scenario Outline: Invalid service request creation
    Given An existing buyer inputs a service request with "<title>", "<description>", <hourlySalary>.
    When A service request creation is generated
    Then The service request should not be added to the database
    And An error message is displayed with each invalid field

    Examples:
      | title                         | description                         | hourlySalary  |
      | Nanny services after school   |                                     | 20            |
      |                               | please take care of my plants <3    | 30            |
    
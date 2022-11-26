Feature: View Service Request As Worker
  As a worker, I want the Peace of Mind Application
  to display a service request (advertisement) that I posted

  Scenario Outline: Valid service request displayed
    Given The worker identified by <id> requested to display a specific advertisement with <id_add>
    When The worker clicks on the service request
    Then The service request with correct ID is queried from the database
    And The advertisement should appear on the webpage

    Examples:
      | id       | id_add   |
      | 1        | 10       |
      | 2        | 11       |

  Scenario Outline: Invalid service request displayed
    Given The worker identified by <id> requested to display a specific advertisement with <id_add>
    When The buyer clicks on the service request
    Then The services request should not open
    And An error message is displayed "Cannot display service request - Service request invalid"

    Examples:
      | id       | id_add   |
      | 1        | 0        |
      | 2        | 1        |
      | 3        | 1000     |
      | 4        | 99       |
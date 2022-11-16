Feature: View All Service Requests As A Worker
  As a worker, I want the Peace of Mind Application
  to display all the service request (adds) that i can apply to 

  Scenario Outline: Valid service request display
    Given The worker identified by <id>
    When The worker clicks on the Services Request Page
    Then The services request up to 10 queries from the database should appear on the page

    Examples:
      | id       |
      | 1        |
      | 2        |

  Scenario Outline: Valid service request according to possibility displayed
    Given The worker identified by <id> inputs a service query with  "<distance from address>" or and <hourlySalary>.
    And The worker is on the Services Request Page
    When The service request is searched
    Then The services request with up to 10 queries from the database should appear on the Page
    And The services request should comply to the query

    Examples:
      | id       | distance from address       | hourlySalary  |
      | 1        | 5 km                        | 20            |
      | 2        |                             | 30            |

  Scenario Outline: No service request according to query present in database
    Given The worker identified by <id> inputs a service query with  "<distance from address>" or and <hourlySalary>.
    And The worker is on the Services Request Page
    When The service request is searched
    And The services request do not comply with the query
    Then A message informing the user that there is not such Service Request is displayed

    Examples:
      | id       | distance from address       | hourlySalary  |
      | 1        | 5 km                        | 20            |
      | 2        |                             | 30            |


    
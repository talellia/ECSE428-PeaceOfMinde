Feature: View All My Service Requests As A Buyer
  As a buyer, I want the Peace of Mind Application
  to display all the service request (adds) that i posted

  Scenario Outline: Valid service request display
    Given The buyer identified by <id>
    When The buyer clicks on the Services Request Page
    Then The services request with up to 10 query from the database should appear on the page

    Examples:
      | id       |
      | 1        |
      | 2        |

  Scenario Outline: Valid service request according to possibility displayed
    Given The buyer identified by <id> inputs a service query with  "<dateCreated>".
    And The buyer is on the Services Request Page
    When The service request is searched.
    Then The services request with up to 10 queries from the database should appear on the Page.
    And The services request should comply to the query.

    Examples:
      | id       | dateCreated                 |
      | 1        | 20-10-2022                  |
      | 2        |                             |

  Scenario Outline: No service request according to query present in database
    Given The buyer identified by <id> inputs a service query with  "<dateCreated>".
    And The buyer is on the Services Request Page
    When The service request is searched.
    And The services request do not comply with the query.
    Then A message informing the user that there is not such Service Request is displayed.

    Examples:
      | id       | dateCreated                 |
      | 1        | 21-10-2022                  |
      | 2        |                             |

  Scenario Outline: Invalid date entered for the query of the service request
    Given The buyer identified by <id> inputs a service query with  "<dateCreated>".
    And The buyer is on the Services Request Page
    When The service request is searched.
    And The "<dateCreated>" is invalid
    Then A message informing the user that there is an invalid date entered (in the future)

    Examples:
      | id       | dateCreated                 |
      | 1        | 20-10-2023                  |
      | 2        | 30-12-2022                  |

        

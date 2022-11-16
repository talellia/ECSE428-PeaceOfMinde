Feature: View My Service Request As A Buyer
  As a buyer, I want the Peace of Mind Application
  to display a service request (adds) that i posted

  Scenario Outline: Valid service request display
    Given The buyer identified by <id> requests to display a specific add with <id_add>
    When The buyer clicks on the Services Request
    Then The services request with correct id is queried from the database
    And The add should appear on the web page

    Examples:
      | id       | id_add   |
      | 1        | 12       |
      | 2        | 21       |

  Scenario Outline: Invalid service request displayed
    Given The buyer identified by <id> requests to display a specific add with <id_add>
    When The buyer clicks on the Services Request
    Then The services request should not open
    And An error message is displayed 

    Examples:
      | id       | id_add   |
      | 1        | 0        |
      | 2        | 1       |
      | 3        | 100      |
      | 4        | 31       |
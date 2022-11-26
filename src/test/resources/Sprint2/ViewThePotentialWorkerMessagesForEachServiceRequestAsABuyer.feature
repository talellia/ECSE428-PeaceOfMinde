Feature: View The Potential Worker Messages For Each Service Request As A Buyer
  As a buyer, I want the Peace of Mind Application
  display the messages from workers per service posted (add)

  Scenario Outline: Valid message from worker for the right add
    Given The buyer identified by <buyer_id> requests to display a specific add with <add_id>.
    And The add with <add_id> contains message from workers (chats) with <chat_id>
    When The buyer clicks on the message button of the add
    Then The application should display the list of workers that messaged the buyer for this specific add

    Examples:
      | buyer_id      | add_id    | chat_id    |
      | 1             | 11        | 111        |
      | 2             | 21        | 211        |                                                    

  Scenario Outline: Invalid chat from worker for the right add
    Given The buyer identified by <buyer_id> requests to display a specific add with <add_id>.
    And The add with <add_id> contains message from workers (chats) with <chat_id>
    When The buyer clicks on the message button of the add
    Then The application should display an error

    Examples:
      | buyer_id      | add_id    | chat_id    |
      | 1             | 11        | -1         |
      | 2             | -1        | 211        |
      | 3             | 31        | 321        |
      | 3             | 32        | 411        |      

Feature: Refuse Worker
  As a buyer in the Peace of Mind Application, 
  I want to refuse a worker for my 
  Service Request

  Scenario: Refuse worker valid
    Given An existing worker has send a message to apply for an active service request to the associated buyer.
    When The buyer refuses the worker for the service request
    Then The chat with the buyer is archived

  Scenario: Refuse worker who has rescinded application
    Given An existing worker has send a message to apply for an active service request to the associated buyer but has rescinded the application
    When The buyer refuses the worker for the service request
    Then An error message is issued.

  Scenario: Refuse worker for invalid service request
    Given An existing worker has send a message to apply for an inactive service request to the associated buyer
    When The buyer refuses the worker for the service request
    Then An error message is issued.
Feature: Accept Worker
  As a buyer in the Peace of Mind Application, 
  I want to accept a worker for my 
  Service Request

  Scenario: Valid worker accept
    Given An existing worker has send a message to apply for an active service request to the associated buyer
    When The buyer accepts the worker for the service request
    Then A message is displayed in the chat
    And The service request is updated in the database to add the worker
    And The service request is archived

  Scenario: Accept worker who has rescinded application
    Given An existing worker has send a message to apply for an active service request to the associated buyer but has since rescinded the application
    When The buyer accepts the worker for the service request
    Then An error message is issued
    And The service request is not updated in the database to add the worker
    And The service request is not archived

  Scenario: Accept worker for an invalid service request
    Given An existing worker has send a message to apply for an active service request to the associated buyer but has since rescinded the application
    When The buyer accepts the worker for the service request
    Then An error message is issued
    And The service request is not updated in the database to add the worker
    And The service request is not archived
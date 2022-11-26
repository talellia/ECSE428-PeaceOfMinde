Feature: Cancel Service Request
  As a buyer, I want the Peace of Mind Application
  to cancel my service request.

  Scenario: Buyer cancels existing service request
    Given Existing buyer cancels existing service request
    When A service request cancellation is generated
    Then The service request should be removed from the database

  Scenario: Buyer cancels non-existing service request
    Given Existing buyer cancels non-existing service request
    When A service request cancellation is generated
    Then The service request should not be removed from the database
    And An error message is issued to buyer
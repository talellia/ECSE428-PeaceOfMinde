Feature: Rescind Job Application for Worker
As a Worker, after I have initiated a chat conversation with a buyer to apply for a job in the Peace of Mind Application System, I can rescind the job application. This will archive the chat conversation with the Buyer.

  Background: 
    Given a worker account with the username "workerUsername" exists in the system.
    And a buyer account with the username "buyerUsername" exists in the system.
    And the application to a job with id "001" listed by that buyer is cancelled

  Scenario: Worker cancels job application to existing job service request
    Given the worker is signed in and viewing the job with id "001".
    And the job is available.
    And the worker has already applied for the job
    When a job application is cancelled 
    Then the job application should be removed from the database
    And the chat conversation should be archived with the buyer

  Scenario: Worker cancels job application to existing job service request with a blocked buyer owner
    Given the worker is signed in and viewing the job with id "001".
    And the job is available.
    And the worker has already applied for the job
    And the buyer with username "buyerUsername" has blocked the worker with username "workerUsername".
    When a job application is cancelled 
    Then the job application should be removed from the database
    And the chat conversation should be archived with the buyer

  Scenario: Worker cancels job application to unavailable job service request
    Given the worker is signed in and viewing the job with id "001".
    And the job is no longer available
    And the worker has already applied for the job
    When a job application is cancelled
    Then the message "This job is currently unavailable" shall be returned



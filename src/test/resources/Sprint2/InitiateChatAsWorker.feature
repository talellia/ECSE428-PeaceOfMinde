Feature: Initiate chat from Worker to Buyer to Apply
As a worker who wants to be apply for a specific job
I want to reuqest a chat to the buyer
So that I can be assigned to this job

  Background: 
    Given a worker account with the username "workerUsername" exists in the system
    And a buyer account with the username "buyerUsername" exists in the system
    And the job with id "001" listed by that buyer is opened

  Scenario: Request Chat for the job
     Given the worker is signed in and viewing the job with id "001"
     And the job is available 
     When I try to click Request Work
     And type in the request message
     Then the request with short message is sent to the Buyer "buyerUsername"
  
  Scenario: Request Chat for an unavailable job
     Given the worker is signed in and viewing the job with id "001"
     And the job is unavailable 
     When I try to click Request Work
     And type in the request message
     Then a message "This job is currenlty unavailable" shall be returned

  Scenario: Request Chat for the blocked Buyer owner
     Given the worker is signed in and viewing the job with id "001"
     And the job is available 
     And the buyer with username "buyerUsername" has blocked the worker with username "workerUsername"
     When I try to view the job
     Then the job is not viewable and a broken link
  

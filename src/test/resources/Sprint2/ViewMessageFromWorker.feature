Feature: View message request from the Worker
As a buyer who wants to get help from a worker
I want to view the messages for the jobs I listed
So that I can assign a worker to it

  Background: 
    Given a worker account with the username "workerUsername" exists
    And a buyer account with the username "buyerUsername" exists
    And the job with id "1" exists in the system

  Scenario: View message from the Worker
     Given the buyer is signed in
     And is viewing the job dashboard with id "1"
     When he tries click on requests lists
     And tries to click on a specific message from worker with username "workerUsername"
     Then the request message from the worker is shown

  Scenario: Open request from the cancelled Worker
     Given the buyer is signed in
     And is viewing the job dashboard with id "001"
     And the worker with username "workerUsername" has now cancelled the request
     When he tries click on requests lists
     And tries to click on a specific message from worker with username "workerUsername"
     Then the message "The worker has cancelled their request" shall be returned to the user

  Scenario: View message from the deactivated Worker account
     Given the buyer is signed in
     And is viewing the job dashboard with id "001"
     And the worker with username "workerUsername" has now deactivated their account
     When he tries click on requests lists
     And tries to click on a specific message from worker with username "workerUsername"
     Then the message "The worker is no longer available!" shall be returned to the user
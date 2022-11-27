Feature: View All Service Requests As A Worker
  As a worker, I want the Peace of Mind Application
  to display all the service requests (advertisments) that I can apply to 
  
  Scenario Outline: Showcase all service requests to worker
    Given the following service requests exist:
    | hourly_rate      | title    									   | serviceOffering_id |
    | 30       				 | "baby sitting"      				 	 | 123    		 				|
    | 50      		  	 | "watch pet" 								 	 | 030     	 				  |
    | 100      		  	 | "fixing complicated stuff"    | 912     		 			  |
    When The worker clicks on the Services Request Page
    Then a maximum of 10 queries from the database should be displayed to the worker

  Scenario Outline: Valid service request according to possibility displayed
    Given the following service requests exist with hourlySalary:
    | hourlySalary     | title    									   | serviceOffering_id |
    | 30       				 | "baby sitting"      				 	 | 123    		 				|
    | 100      		  	 | "watch pet" 								 	 | 030     	 				  |
    | 100      		  	 | "fixing complicated stuff"    | 912     		 			  |
    When The worker conducts a service request with hourlySalary "100"
    Then Up to 10 valid services from the database should appear on the page
    Examples:
      | hourlySalary     | title    									   | serviceOffering_id |
    	| 100      		  	 | "watch pet" 								 	 | 030     	 				  |
    	| 100      		  	 | "fixing complicated stuff"    | 912     		 			  |

  Scenario Outline: No service request according to query present in database
    Given The following service requests exist with serviceOffering IDs:
    | serviceOffering_id 	|  title    										|
    | 1001       				 	|	 "baby sitting"      					|
    | 1201    		  	 		|  "watch pet" 							  	|
    | 1301     		  	 		|  "fixing complicated stuff"  	|    
    When The worker searches for a service offering with id "1401"
    Then The service request fails
    And the error message "Service Request doesn't exist!" is issued to worker


    
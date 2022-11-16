package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewAllServiceRequestsAsWorkerStepDefs extends SpringIntegrationTest {

    /*
        Note:  I would review the Cucumber scenarios, it was written in a rush
     */

    @Given("The worker identified by {int}")
    public void theWorkerIdentifiedById(int id) {
    }

    @When("The worker clicks on the Services Request Page")
    public void theWorkerClicksOnTheServicesRequestPage() {

    }

    @Then("The services request up to {int} queries from the database should appear on the page")
    public void theServicesRequestUpToQueriesFromTheDatabaseShouldAppearOnThePage(int arg0) {
    }

    @Given("The worker identified by {int} inputs a service query with  {string} or and {int}.")
    public void theWorkerIdentifiedByIdInputsAServiceQueryWithOrAndHourlySalary(int id, String arg0, int hourlySalary) {
    }

    @And("The worker is on the Services Request Page")
    public void theWorkerIsOnTheServicesRequestPage() {
    }


    @When("The service request is searched")
    public void theServiceRequestIsSearched() {

    }

    @Then("The services request with up to {int} queries from the database should appear on the Page")
    public void theServicesRequestWithUpToQueriesFromTheDatabaseShouldAppearOnThePage(int arg0) {

    }

    @And("The services request should comply to the query")
    public void theServicesRequestShouldComplyToTheQuery() {
    }

    @And("The services request do not comply with the query")
    public void theServicesRequestDoNotComplyWithTheQuery() {

    }

    @Then("A message informing the user that there is not such Service Request is displayed")
    public void aMessageInformingTheUserThatThereIsNotSuchServiceRequestIsDisplayed() {
    }
}

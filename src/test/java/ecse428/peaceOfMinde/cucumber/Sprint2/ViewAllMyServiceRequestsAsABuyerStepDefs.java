package ecse428.peaceOfMinde.cucumber.Sprint2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewAllMyServiceRequestsAsABuyerStepDefs {

     /*
        Note:  I would review the Cucumber scenarios, it was written in a rush
     */

    @Given("The buyer identified by {int}")
    public void theBuyerIdentifiedById(int id) {

    }

    @When("The buyer clicks on the Services Request Page")
    public void theBuyerClicksOnTheServicesRequestPage() {

    }

    @Then("The services request with up to {int} query from the database should appear on the page")
    public void theServicesRequestWithUpToQueryFromTheDatabaseShouldAppearOnThePage(int arg0) {

    }


    @Given("The buyer identified by {int} inputs a service query with  {string}.")
    public void theBuyerIdentifiedByIdInputsAServiceQueryWith(int id, String arg0) {
    }

    @And("The buyer is on the Services Request Page")
    public void theBuyerIsOnTheServicesRequestPage() {

    }

    @When("The service request is searched.")
    public void theServiceRequestIsSearched() {

    }

    @Then("The services request with up to {int} queries from the database should appear on the Page.")
    public void theServicesRequestWithUpToQueriesFromTheDatabaseShouldAppearOnThePage(int arg0) {

    }

    @And("The services request should comply to the query.")
    public void theServicesRequestShouldComplyToTheQuery() {

    }

    @And("The services request do not comply with the query.")
    public void theServicesRequestDoNotComplyWithTheQuery() {

    }

    @Then("A message informing the user that there is not such Service Request is displayed.")
    public void aMessageInformingTheUserThatThereIsNotSuchServiceRequestIsDisplayed() {

    }

    @And("The {string} is invalid")
    public void theIsInvalid(String arg0) {

    }

    @Then("A message informing the user that there is an invalid date entered \\(in the future)")
    public void aMessageInformingTheUserThatThereIsAnInvalidDateEnteredInTheFuture() {
    }

}

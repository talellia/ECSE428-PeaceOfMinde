package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewMyRequestsAsABuyerStepDefs extends SpringIntegrationTest {

    /*
        Note: this gherkin test was badly made, please reformat it to match your implementation
              At the very least the examples must be reworked (id_add must be a list of ids and a new wantedId column must be added
              thus if the wanted id is in the least then the add is displayed, else an error message is returned)
     */

    @Given("The buyer identified by {int} requests to display a specific add with {int}")
    public void theBuyerIdentifiedByIdRequestsToDisplayASpecificAddWithId(int id, int idAdd) {

    }

    @When("The buyer clicks on the Services Request")
    public void theBuyerClicksOnTheServicesRequest() {
    }

    @Then("The services request with correct id is queried from the database")
    public void theServicesRequestWithCorrectIdIsQueriedFromTheDatabase() {

    }

    @And("The add should appear on the web page")
    public void theAddShouldAppearOnTheWebPage() {

    }

    @Then("The services request should not open")
    public void theServicesRequestShouldNotOpen() {

    }

    @And("An error message is displayed")
    public void anErrorMessageIsDisplayed() {

    }
}

package ecse428.peaceOfMinde.cucumber.Sprint2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewServiceRequestsAsWorkerStepDefs {

    /*
        Note: this gherkin test was badly made, please reformat it to match your implementation
              At the very least the examples must be reworked (id_add must be a list of ids and a new wantedId column must be added
              thus if the wanted id is in the least then the add is displayed, else an error message is returned)
     */

    @Given("The worker identified by {int} requested to display a specific advertisement with {int}")
    public void theWorkerIdentifiedByIdRequestedToDisplayASpecificAdvertisementWithId(int id, int idAdd) {

    }


    @When("The worker clicks on the service request")
    public void theWorkerClicksOnTheServiceRequest() {

    }

    @Then("The service request with correct ID is queried from the database")
    public void theServiceRequestWithCorrectIDIsQueriedFromTheDatabase() {

    }

    @And("The advertisement should appear on the webpage")
    public void theAdvertisementShouldAppearOnTheWebpage() {

    }

    @When("The buyer clicks on the service request")
    public void theBuyerClicksOnTheServiceRequest() {

    }

    @And("An error message is displayed {string}")
    public void anErrorMessageIsDisplayed(String arg0) {
    }
}

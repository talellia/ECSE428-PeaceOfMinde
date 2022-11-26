package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewThePotentialWorkerMessagesForEachServiceRequestAsABuyerStepDefs extends SpringIntegrationTest {


    @Given("The buyer identified by {int} requests to display a specific add with {int}.")
    public void theBuyerIdentifiedByIdRequestsToDisplayASpecificAddWithId(int id, int idAdd) {
    }


    @And("The add with {int} contains message from workers \\(chats) with {int}")
    public void theAddWithAdd_idContainsMessageFromWorkersChatsWithChat_id(int idAdd, int idChat) {
    }

    @When("The buyer clicks on the message button of the add")
    public void theBuyerClicksOnTheMessageButtonOfTheAdd() {

    }

    @Then("The application should display the list of workers that messaged the buyer for this specific add")
    public void theApplicationShouldDisplayTheListOfWorkersThatMessagedTheBuyerForThisSpecificAdd() {

    }

    @Then("The application should display an error")
    public void theApplicationShouldDisplayAnError() {
    }
}

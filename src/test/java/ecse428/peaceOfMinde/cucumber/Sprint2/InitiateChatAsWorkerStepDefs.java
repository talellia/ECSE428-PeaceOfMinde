package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class InitiateChatAsWorkerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;


    @Given("a worker account with the username {string} exists in the system")
    public void aWorkerAccountWithTheUsernameExistsInTheSystem(String arg0) {
    }

    @And("a buyer account with the username {string} exists in the system")
    public void aBuyerAccountWithTheUsernameExistsInTheSystem(String arg0) {

    }

    @And("the job with id {string} listed by that buyer is opened")
    public void theJobWithIdListedByThatBuyerIsOpened(String arg0) {

    }

    @Given("the worker is signed in and viewing the job with id {string}")
    public void theWorkerIsSignedInAndViewingTheJobWithId(String arg0) {

    }

    @And("the job is available")
    public void theJobIsAvailable() {

    }

    @When("I try to click Request Work")
    public void iTryToClickRequestWork() {

    }

    @And("type in the request message")
    public void typeInTheRequestMessage() {

    }

    @Then("the request with short message is sent to the Buyer {string}")
    public void theRequestWithShortMessageIsSentToTheBuyer(String arg0) {

    }

    @And("the job is unavailable")
    public void theJobIsUnavailable() {

    }

    @Then("a message {string} shall be returned")
    public void aMessageShallBeReturned(String arg0) {

    }

    @And("the buyer with username {string} has blocked the worker with username {string}")
    public void theBuyerWithUsernameHasBlockedTheWorkerWithUsername(String arg0, String arg1) {

    }

    @When("I try to view the job")
    public void iTryToViewTheJob() {

    }

    @Then("the job is not viewable and a broken link")
    public void theJobIsNotViewableAndABrokenLink() {

    }
}

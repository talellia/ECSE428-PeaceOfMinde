package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class RescindJobapplicationStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;

    private BuyerDto buyerDto;

    @Given("a worker account with the username {string} exists in the system.")
    public void aWorkerAccountWithTheUsernameExistsInTheSystem(String arg0) {
    }

    @And("a buyer account with the username {string} exists in the system.")
    public void aBuyerAccountWithTheUsernameExistsInTheSystem(String arg0) {

    }

    @And("the application to a job with id {string} listed by that buyer is cancelled")
    public void theApplicationToAJobWithIdListedByThatBuyerIsCancelled(String arg0) {
    }

    @Given("the worker is signed in and viewing the job with id {string}.")
    public void theWorkerIsSignedInAndViewingTheJobWithId(String arg0) {

    }

    @And("the job is available.")
    public void theJobIsAvailable() {

    }

    @And("the worker has already applied for the job")
    public void theWorkerHasAlreadyAppliedForTheJob() {

    }

    @When("a job application is cancelled")
    public void aJobApplicationIsCancelled() {

    }

    @Then("the job application should be removed from the database")
    public void theJobApplicationShouldBeRemovedFromTheDatabase() {

    }

    @And("the chat conversation should be archived with the buyer")
    public void theChatConversationShouldBeArchivedWithTheBuyer() {

    }

    @And("the buyer with username {string} has blocked the worker with username {string}.")
    public void theBuyerWithUsernameHasBlockedTheWorkerWithUsername(String arg0, String arg1) {

    }

    @And("the job is no longer available")
    public void theJobIsNoLongerAvailable() {

    }

    @Then("the message {string} shall be returned")
    public void theMessageShallBeReturned(String arg0) {
    }
}

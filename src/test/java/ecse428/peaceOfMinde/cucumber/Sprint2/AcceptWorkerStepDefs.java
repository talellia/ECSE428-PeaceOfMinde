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

public class AcceptWorkerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;


    @Given("An existing worker has send a message to apply for an active service request to the associated buyer")
    public void anExistingWorkerHasSendAMessageToApplyForAnActiveServiceRequestToTheAssociatedBuyer() {
    }

    @When("The buyer accepts the worker for the service request")
    public void theBuyerAcceptsTheWorkerForTheServiceRequest() {

    }

    @Then("A message is displayed in the chat")
    public void aMessageIsDisplayedInTheChat() {

    }

    @And("The service request is updated in the database to add the worker")
    public void theServiceRequestIsUpdatedInTheDatabaseToAddTheWorker() {

    }

    @And("The service request is archived")
    public void theServiceRequestIsArchived() {

    }

    @Given("An existing worker has send a message to apply for an active service request to the associated buyer but has since rescinded the application")
    public void anExistingWorkerHasSendAMessageToApplyForAnActiveServiceRequestToTheAssociatedBuyerButHasSinceRescindedTheApplication() {

    }

    @Then("An error message is issued")
    public void anErrorMessageIsIssued() {

    }

    @And("The service request is not updated in the database to add the worker")
    public void theServiceRequestIsNotUpdatedInTheDatabaseToAddTheWorker() {

    }

    @And("The service request is not archived")
    public void theServiceRequestIsNotArchived() {
    }

}

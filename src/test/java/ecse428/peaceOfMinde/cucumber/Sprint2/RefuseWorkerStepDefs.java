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

public class RefuseWorkerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;

    @Given("An existing worker has send a message to apply for an active service request to the associated buyer.")
    public void anExistingWorkerHasSendAMessageToApplyForAnActiveServiceRequestToTheAssociatedBuyer2() {
    }

    @When("The buyer refuses the worker for the service request")
    public void theBuyerRefusesTheWorkerForTheServiceRequest() {

    }

    @Then("The chat with the buyer is archived")
    public void theChatWithTheBuyerIsArchived() {

    }

    @Given("An existing worker has send a message to apply for an active service request to the associated buyer but has rescinded the application")
    public void anExistingWorkerHasSendAMessageToApplyForAnActiveServiceRequestToTheAssociatedBuyerButHasRescindedTheApplication() {

    }

    @Then("An error message is issued.")
    public void anErrorMessageIsIssued() {

    }

    @Given("An existing worker has send a message to apply for an inactive service request to the associated buyer")
    public void anExistingWorkerHasSendAMessageToApplyForAnInactiveServiceRequestToTheAssociatedBuyer() {

    }
}

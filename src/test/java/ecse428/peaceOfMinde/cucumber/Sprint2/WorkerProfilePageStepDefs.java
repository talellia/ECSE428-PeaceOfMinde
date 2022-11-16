package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class WorkerProfilePageStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;

    /*
    NOTE : most of the stepdefs are defined in the WorkerAccountPageStepDefs.
           If this happens to not work or you need a different setup, change the wording in the .feature file
           and create the new stepdef below
     */

    @When("the Worker clicks the My Profile button")
    public void theWorkerClicksTheMyAccountButton() {

    }

    @Then("the Worker Profile Page is displayed")
    public void theWorkerProfilePageIsDisplayed() {
    }
}

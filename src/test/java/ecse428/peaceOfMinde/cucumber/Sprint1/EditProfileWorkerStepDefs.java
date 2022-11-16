package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class EditProfileWorkerStepDefs extends SpringIntegrationTest {
    @Autowired
    private PersonController personController;
    private ResponseEntity<?> response;

    @Given("^a worker wants to edit their worker profile within the  PeaceOfMinde Management System$")
    public void a_worker_wants_to_edit_their_worker_profile_within_the_peace_of_minde_management_system() {
        WorkerDto dto = new WorkerDto();
        dto.setPassword("hello123");
        dto.setEmail("hello@gmail.com");
        dto.setUserName("hello");
        personController.createWorker(dto);
        response = personController.updateWorker("hello@gmail.com", dto);
    }

    @When("Worker {string} requests to edit their worker profile with a unique email {string} and a {string}")
    public void workerRequestsToEditTheirWorkerProfileWithAUniqueEmailAndA(String arg0, String arg1, String arg2) {
        WorkerDto dto = new WorkerDto();
        dto.setUserName(arg0);
        WorkerDto updatedDto = new WorkerDto();
        updatedDto.setEmail(arg1);
        updatedDto.setPassword(arg2);
        response = personController.updateWorker(arg1, updatedDto);
    }


    @Given("an existing worker who inputs a username {string}, email {string}, and password {string}")
    public void anExistingWorkerWhoInputsAUsernameEmailAndPassword(String arg0, String arg1, String arg2) {
        WorkerDto existingWorkerDto = new WorkerDto();
        existingWorkerDto.setUserName(arg0);
        existingWorkerDto.setEmail(arg1);
        existingWorkerDto.setPassword(arg2);
        personController.createWorker(existingWorkerDto);
        WorkerDto newWorkerDto = new WorkerDto();
        newWorkerDto.setEmail("Cooper_B@gmail.com");
        newWorkerDto.setUserName("Jones_J");
        personController.createWorker(newWorkerDto);
        response = personController.updateWorker("Cooper_B@gmail.com", existingWorkerDto);
    }

    @When("the existing worker requests to update their profile")
    public void theExistingWorkerRequestsToUpdateTheirProfile() {
        WorkerDto existingWorkerDto = new WorkerDto();
        existingWorkerDto.setUserName("hello");
        existingWorkerDto.setEmail("hello@gmail.com");
        personController.createWorker(existingWorkerDto);
        WorkerDto newWorkerDto = new WorkerDto();
        newWorkerDto.setEmail("Cooper_B@gmail.com");
        newWorkerDto.setUserName("Jones_J");
        personController.createWorker(newWorkerDto);
        response = personController.updateWorker("Cooper_B@gmail.com", existingWorkerDto);
    }

    @And("the Worker account is not updated")
    public void theWorkerAccountIsNotUpdated() {
        assertThat(response.getBody().toString().contains("400"));
    }


    @And("there exists a worker with username {string} and email {string} in the PeaceOfMinde Management System")
    public void thereExistsAWorkerWithUsernameAndEmail(String arg0, String arg1) {
        WorkerDto dto = new WorkerDto();
        dto.setUserName(arg0);
        dto.setEmail(arg1);
        response = personController.getWorker(arg1);
        assertThat(response.getBody().toString().contains(arg0));
        assertThat(response.getBody().toString().contains(arg1));
    }

    @Then("the worker {string} and {string} is updated")
    public void theWorkerAndIsUpdated(String arg0, String arg1) {
        assertThat(response.getBody().toString().contains(arg0));
        assertThat(response.getBody().toString().contains(arg1));
    }

    @Then("a worker message {string} is issued")
    public void aWorkerMessageIsIssued(String arg0) {
        String exception = (String) response.getBody();
        assertThat(exception).isEqualTo(arg0);
    }
}

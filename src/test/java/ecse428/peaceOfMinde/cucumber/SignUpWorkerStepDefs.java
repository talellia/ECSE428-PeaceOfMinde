package ecse428.peaceOfMinde.cucumber;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Worker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpWorkerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;

    @Given("^a user wants to sign up to the PeaceOfMinde Management System as a Worker user_type$")
    public void workerSignUp(){
        
    }

    @When("Worker {string} requests to sign up as a Worker with a unique email {string} and a {string}")
    public void workerUser_nameRequestsToSignUpAsAWorkerWithAUniqueEmailUser_emailAndAUser_password(String username, String email, String password) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setFirstName("firstName");
        workerDto.setLastName("lastName");
        workerDto.setResidentialAddress("address");
        workerDto.setUserName(username);
        workerDto.setEmail(email);
        workerDto.setPassword(password);
        response = personController.createWorker(workerDto);
    }

    @Then("a new worker is generated")
    public void aNewUser_idIsGenerated() {
        assertThat(response.getBody()).isInstanceOf(WorkerDto.class);
        WorkerDto dto = (WorkerDto) response.getBody();
        assertThat(workerRepository.findById(dto.getId()).isPresent()).isTrue();
    }

    @Given("a new user who inputs a username {string}, email {string}, and password {string}")
    public void aNewUserWhoInputsAUsernameUser_nameEmailUser_emailAndPasswordUser_password(String username, String email, String password) {
        workerDto = new WorkerDto();
        workerDto.setFirstName("firstName");
        workerDto.setLastName("lastName");
        workerDto.setResidentialAddress("address");
        workerDto.setUserName(username);
        workerDto.setEmail(email);
        workerDto.setPassword(password);
    }

    @And("there exists a worker with username {string} and email {string}")
    public void thereExistsAUserWithUsernameAndEmail(String username, String email) {
        Worker worker = new Worker();
        worker.setFirstName("firstName");
        worker.setLastName("lastName");
        worker.setResidentialAddress("address");
        worker.setUsername(username);
        worker.setEmail(email);
        worker.setPassword("password");
        workerRepository.save(worker);
    }

    @When("the new user requests to requests to sign up as a Worker")
    public void theNewUserRequestsToRequestsToSignUpAsAWorker() {
        response = personController.createWorker(workerDto);
    }

    @Then("a message {string} is issued to worker")
    public void aMessageMessageIsIssued(String message) {
        assertThat(response.getBody()).isInstanceOf(String.class);
    }

    @And("the Worker account is not created")
    public void theWorkerAccountIsNotCreated() {
        assertThat(StreamSupport.stream(workerRepository.findAll().spliterator(), false).count()).isEqualTo(1);
    }
}

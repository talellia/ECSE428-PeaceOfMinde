package ecse428.peaceOfMinde.cucumber;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Worker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginWorkerStepDefs extends SpringIntegrationTest{


    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    @Given("^the following Workers exist:$")
    public void followingWorkersExist(DataTable table)
    {
        List<List<String>> rows = table.asLists(String.class);
        rows.stream().skip(1).forEach(columns->{
            Worker temp = new Worker();
            temp.setUsername(columns.get(0));
            temp.setEmail(columns.get(1));
            temp.setPassword(columns.get(2));
            temp.setId(Integer.parseInt(columns.get(3)));
            workerRepository.save(temp);
        } );
    }


    @When("a request to login worker is issued with username {string} and password {string}")
    public void aRequestToLoginWorkerIsIssuedWithUsernameAndPassword(String arg0, String arg1) {
        WorkerDto dto = new WorkerDto();
        dto.setUserName(arg0);
        dto.setPassword(arg1);
        response = personController.loginWorkerByUsername(dto);
    }

    @Then("Worker with id {string} is logged in")
    public void workerWithIdIsLoggedIn(String arg0) {
        assertThat(response.getBody()).isInstanceOf(WorkerDto.class);
    }

    @When("a request to login worker is issued with email {string} and password {string}")
    public void aRequestToLoginWorkerIsIssuedWithEmailAndPassword(String arg0, String arg1) {
        WorkerDto dto = new WorkerDto();
        dto.setEmail(arg0);
        dto.setPassword(arg1);
        response = personController.loginWorkerByEmail(dto);
    }

    @When("a request to login worker is issued with user name {string} and password {string}")
    public void aRequestToLoginWorkerIsIssuedWithUserNameAttempt_user_nameAndPasswordAttempt_password(String username, String password) {
        WorkerDto dto = new WorkerDto();
        dto.setUserName(username);
        dto.setPassword(password);
        response = personController.loginWorkerByUsername(dto);
    }

    @Then("login worker fails")
    public void loginWorkerFails() {
        assertThat(response.getBody()).isInstanceOf(String.class);
    }

    @And("the error message {string} is issued to worker")
    public void theErrorMessageIsIssuedToWorker(String arg0) {
        String exception = (String) response.getBody();
        assertThat(exception).isEqualTo(arg0);
    }

}

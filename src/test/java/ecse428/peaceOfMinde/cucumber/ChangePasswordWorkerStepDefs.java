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
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


public class ChangePasswordWorkerStepDefs {
  
  @Autowired
  WorkerRepository workerRepository;
  @Autowired
  private PersonController personController;
  
  private ResponseEntity<?> response;
  
  @Given("the following workers exist:")
  public void theFollowingWorkersExist(DataTable table) {
    List<Map<String, String>> data = table.asMaps();

    // For each row
    for (Map<String, String> row : data) {
      String userName = row.get("user_name");
      String email = row.get("user_email");
      String password = row.get("user_password");
      
      Worker worker = new Worker();
      worker.setUsername(userName);
      worker.setEmail(email);
      worker.setPassword(password);
      
      workerRepository.save(worker);
    }
  }
  
  @When("a request to change password is sent by worker with unique email {string} and a new password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndNewPassword(String email, String newPassword) {
    WorkerDto dto = new WorkerDto();
    dto.setEmail(email);
    dto.setPassword(newPassword);
    response = personController.updateWorkerPassword(email, newPassword, dto);
  }
  
  @Then("the Worker with user ID {string} has a new password in the database.")
  public void workerWithIdIsLoggedIn(String id) {
    assertThat(response.getBody()).isInstanceOf(WorkerDto.class);
  }
  
  @Given("the following users exist:")
  public void theFollowingWorkersExistInSystem(DataTable table) {
    List<Map<String, String>> data = table.asMaps();

    // For each row
    for (Map<String, String> row : data) {
      String userName = row.get("user_name");
      String email = row.get("user_email");
      String password = row.get("user_password");
      
      Worker worker = new Worker();
      worker.setUsername(userName);
      worker.setEmail(email);
      worker.setPassword(password);
      
      workerRepository.save(worker);
    }
  }
  
  @When("a request to change password is sent by worker with unique email {string} and the same password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndSamePassword(String email, String password) {
    WorkerDto dto = new WorkerDto();
    dto.setEmail(email);
    dto.setPassword(password);
    response = personController.updateWorkerPassword(email, password, dto);
  }
  
  @Then("the password is not updated")
  public void updatePasswordFails() {
      assertThat(response.getBody()).isInstanceOf(String.class);
  }
  
  @And("the error message {string} is issued to worker")
  public void theErrorMessageIsIssuedToWorker(String message) {
    String exception = (String) response.getBody();
    assertThat(exception).isEqualTo(message);
  }
}

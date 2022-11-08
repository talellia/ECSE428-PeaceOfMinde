package ecse428.peaceOfMinde.cucumber;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Buyer;
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
  
  @Given("the following workers exist in the system:")
  public void theFollowingWorkersExist(DataTable table) {
    List<List<String>> rows = table.asLists(String.class);
    rows.stream().skip(1).forEach(columns->{
      Worker temp = new Worker();
      temp.setUsername(columns.get(0));
      temp.setEmail(columns.get(1));
      temp.setPassword(columns.get(2));
      temp.setId(Integer.parseInt(columns.get(4)));
      workerRepository.save(temp);
    } );
  }
  
  @When("a request to change password is sent by worker with unique email {string} and a new password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndNewPassword(String email, String newPassword) {
    WorkerDto workerDto = new WorkerDto();
    workerDto.setFirstName("firstName");
    workerDto.setLastName("lastName");
    workerDto.setResidentialAddress("address");
    workerDto.setUserName("username");
    workerDto.setEmail(email);
    workerDto.setPassword("password");
    response = personController.updateWorkerPassword(email, newPassword, workerDto);
  }
  
  @Then("the Worker with user ID {string} has a new password in the database.")
  public void workerWithIdIsLoggedIn(String id) {
    assertThat(response.getBody()).isInstanceOf(WorkerDto.class);
  }

  
  @When("a request to change password is sent by worker with unique email {string} and the same password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndSamePassword(String email, String password) {
    WorkerDto workerDto = new WorkerDto();
    workerDto.setFirstName("firstName");
    workerDto.setLastName("lastName");
    workerDto.setResidentialAddress("address");
    workerDto.setUserName("username");
    workerDto.setEmail(email);
    workerDto.setPassword("password");
    response = personController.updateWorkerPassword(email, password, workerDto);
  }
  
  @Then("the password is not updated for worker")
  public void updatePasswordFails() {
      assertThat(response.getBody()).isInstanceOf(String.class);
  }
  
  @And("the password error message {string} is issued to worker")
  public void theErrorMessageIsIssuedToWorker(String message) {
    String exception = (String) response.getBody();
    assertThat(exception).isEqualTo(message);
  }
}

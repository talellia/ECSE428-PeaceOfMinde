package ecse428.peaceOfMinde.cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.model.Buyer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePasswordBuyerStepDefs {

  @Autowired
  BuyerRepository buyerRepository;
  @Autowired
  private PersonController personController;
  
  private ResponseEntity<?> response;
  
  @Given("the following buyers exist:")
  public void theFollowingBuyersExist(DataTable table) {
    List<Map<String, String>> data = table.asMaps();

    // For each row
    for (Map<String, String> row : data) {
      String userName = row.get("user_name");
      String email = row.get("user_email");
      String password = row.get("user_password");
      
      Buyer buyer = new Buyer();
      buyer.setUsername(userName);
      buyer.setEmail(email);
      buyer.setPassword(password);
      
      buyerRepository.save(buyer);
    }
  }
  
  @When("a request to change password is sent by buyer with unique email {string} and a new password {string")
  public void aRequestToChangePasswordIsIssuedWithEmailAndNewPassword(String email, String newPassword) {
    BuyerDto dto = new BuyerDto();
    dto.setEmail(email);
    dto.setPassword(newPassword);
    response = personController.updateBuyerPassword(email, newPassword, dto);
  }
  
  @Then("the buyer with user ID {string} has a new password in the database")
  public void buyerWithIdIsLoggedIn(String id) {
    assertThat(response.getBody()).isInstanceOf(BuyerDto.class);
  }
  
  @Given("the following users exist:")
  public void theFollowingBuyersExistInSystem(DataTable table) {
    List<Map<String, String>> data = table.asMaps();

    // For each row
    for (Map<String, String> row : data) {
      String userName = row.get("user_name");
      String email = row.get("user_email");
      String password = row.get("user_password");
      
      Buyer buyer = new Buyer();
      buyer.setUsername(userName);
      buyer.setEmail(email);
      buyer.setPassword(password);
      
      buyerRepository.save(buyer);
    }
  }
  
  @When("a request to change password is sent by buyer with unique email {string} and the same password {string")
  public void aRequestToChangePasswordIsIssuedWithEmailAndSamePassword(String email, String password) {
    BuyerDto dto = new BuyerDto();
    dto.setEmail(email);
    dto.setPassword(password);
    response = personController.updateBuyerPassword(email, password, dto);
  }
  
  @Then("the password is not updated")
  public void updatePasswordFails() {
      assertThat(response.getBody()).isInstanceOf(String.class);
  }
  
  @And("the error message {string} is issued to buyer")
  public void theErrorMessageIsIssuedToBuyer(String message) {
    String exception = (String) response.getBody();
    assertThat(exception).isEqualTo(message);
  }
  
}

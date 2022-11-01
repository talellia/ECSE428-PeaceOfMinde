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
  
  @Given("the following buyers exist in the system:")
  public void theFollowingBuyersExist(DataTable table) {
    List<List<String>> rows = table.asLists(String.class);
    rows.stream().skip(1).forEach(columns->{
      Buyer temp = new Buyer();
      temp.setUsername(columns.get(0));
      temp.setEmail(columns.get(1));
      temp.setPassword(columns.get(2));
      temp.setId(Integer.parseInt(columns.get(4)));
      buyerRepository.save(temp);
    } );
  }

  
  @When("a request to change password is sent by buyer with unique email {string} and a new password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndNewPassword(String email, String newPassword) {
    BuyerDto buyerDto = new BuyerDto();
    buyerDto.setFirstName("firstName");
    buyerDto.setLastName("lastName");
    buyerDto.setResidentialAddress("address");
    buyerDto.setUserName("username");
    buyerDto.setEmail(email);
    buyerDto.setPassword("password");
    response = personController.updateBuyerPassword(email, newPassword, buyerDto);
  }
  
  @Then("the buyer with user ID {string} has a new password in the database.")
  public void buyerWithIdIsLoggedIn(String id) {
    assertThat(response.getBody()).isInstanceOf(BuyerDto.class);
  }

  
  @When("a request to change password is sent by buyer with unique email {string} and the same password {string}")
  public void aRequestToChangePasswordIsIssuedWithEmailAndSamePassword(String email, String password) {
      BuyerDto buyerDto = new BuyerDto();
      buyerDto.setFirstName("firstName");
      buyerDto.setLastName("lastName");
      buyerDto.setResidentialAddress("address");
      buyerDto.setUserName("username");
      buyerDto.setEmail(email);
      buyerDto.setPassword("password");
    response = personController.updateBuyerPassword(email, password, buyerDto);
  }
  
  @Then("the password is not updated for buyer")
  public void updatePasswordFails() {
      assertThat(response.getBody()).isInstanceOf(String.class);
  }
  
  @And("the password error message {string} is issued to buyer")
  public void theErrorMessageIsIssuedToBuyer(String message) {
    String exception = (String) response.getBody();
    assertThat(exception).isEqualTo(message);
  }
  
}

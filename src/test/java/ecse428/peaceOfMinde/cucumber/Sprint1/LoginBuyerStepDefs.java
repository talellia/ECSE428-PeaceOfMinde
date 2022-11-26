package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginBuyerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    @Given("the following Buyers exist:")
    public void theFollowingBuyersExist(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        rows.stream().skip(1).forEach(columns->{
            Buyer temp = new Buyer();
            temp.setUsername(columns.get(0));
            temp.setEmail(columns.get(1));
            temp.setPassword(columns.get(2));
            temp.setId(Integer.parseInt(columns.get(3)));
            buyerRepository.save(temp);
        } );
    }

    @Then("Buyer with id {string} is logged in")
    public void buyerWithIdIsLoggedIn(String arg0) {
        assertThat(response.getBody()).isInstanceOf(BuyerDto.class);
    }

    @When("a request to login buyer is issued with username {string} and password {string}")
    public void aRequestToLoginBuyerIsIssuedWithUsernameAndPassword(String arg0, String arg1) {
        BuyerDto dto = new BuyerDto();
        dto.setUserName(arg0);
        dto.setPassword(arg1);
        response = personController.loginBuyerByUsername(dto);
    }

    @When("a request to login buyer is issued with email {string} and password {string}")
    public void aRequestToLoginBuyerIsIssuedWithEmailAndPassword(String arg0, String arg1) {
        BuyerDto dto = new BuyerDto();
        dto.setEmail(arg0);
        dto.setPassword(arg1);
        response = personController.loginBuyerByEmail(dto);
    }

    @When("a request to login buyer is issued with user name {string} and password {string}")
    public void aRequestToLoginBuyerIsIssuedWithUserNameAttempt_user_nameAndPasswordAttempt_password(String username, String password) {
        BuyerDto dto = new BuyerDto();
        dto.setUserName(username);
        dto.setPassword(password);
        response = personController.loginBuyerByUsername(dto);
    }

    @Then("login buyer fails")
    public void loginBuyerFails() {
        assertThat(response.getBody()).isInstanceOf(String.class);
    }

    @And("the error message {string} is issued to buyer")
    public void theErrorMessageIsIssuedToBuyer(String arg0) {
        String exception = (String) response.getBody();
        assertThat(exception).isEqualTo(arg0);
    }
}

package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Buyer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpBuyerStepDefs extends SpringIntegrationTest {
    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;

    @Given("^a user wants to sign up to the PeaceOfMinde Management System as a Buyer user_type$")
    public void buyerSignUp(){

    }

    @When("buyer {string} requests to sign up as a Buyer with a unique email {string} and a {string}")
    public void buyerUser_nameRequestsToSignUpAsABuyerWithAUniqueEmailUser_emailAndAUser_password(String username, String email, String password) {
        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setFirstName("firstName");
        buyerDto.setLastName("lastName");
        buyerDto.setResidentialAddress("address");
        buyerDto.setUserName(username);
        buyerDto.setEmail(email);
        buyerDto.setPassword(password);
        response = personController.createBuyer(buyerDto);
    }

    @Then("a new buyer is generated")
    public void aNewBuyerIsGenerated() {
        assertThat(response.getBody()).isInstanceOf(BuyerDto.class);
        BuyerDto dto = (BuyerDto) response.getBody();
        assertThat(buyerRepository.findById(dto.getId()).isPresent()).isTrue();
    }

    @Given("a new buyer who inputs a username {string}, email {string}, and password {string}")
    public void aNewBuyerWhoInputsAUsernameUser_nameEmailUser_emailAndPasswordUser_password(String username, String email, String password) {
        buyerDto = new BuyerDto();
        buyerDto.setFirstName("firstName");
        buyerDto.setLastName("lastName");
        buyerDto.setResidentialAddress("address");
        buyerDto.setUserName(username);
        buyerDto.setEmail(email);
        buyerDto.setPassword(password);
    }

    @And("there exists a buyer with username {string} and email {string}")
    public void thereExistsABuyerWithUsernameAndEmail(String arg0, String arg1) {
        Buyer buyer = new Buyer();
        buyer.setFirstName("firstName");
        buyer.setLastName("lastName");
        buyer.setResidentialAddress("address");
        buyer.setUsername(arg0);
        buyer.setEmail(arg1);
        buyer.setPassword("password");
        buyerRepository.save(buyer);
    }

    @When("the new user requests to sign up as a Buyer in ChessMate")
    public void theNewUserRequestsToSignUpAsABuyerInChessMate() {
        response = personController.createBuyer(buyerDto);

    }

    @Then("a message {string} is issued to buyer")
    public void aMessageMessageIsIssuedToBuyer(String message) {
        assertThat(response.getBody()).isInstanceOf(String.class);
    }

    @And("the Buyer account is not created")
    public void theBuyerAccountIsNotCreated() {
        assertThat(StreamSupport.stream(buyerRepository.findAll().spliterator(), false).count()).isEqualTo(1);
    }
}

package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dto.BuyerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class EditProfileBuyerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    private ResponseEntity<?> response;



    @When("^the existing buyer requests to update their profile$")
    public void theExistingBuyerRequestsToUpdateTheirProfile(){
        BuyerDto existingBuyerDto = new BuyerDto();
        existingBuyerDto.setUserName("hello");
        existingBuyerDto.setEmail("hello@gmail.com");
        personController.createBuyer(existingBuyerDto);
        BuyerDto newBuyerDto = new BuyerDto();
        newBuyerDto.setEmail("Cooper_B@gmail.com");
        newBuyerDto.setUserName("Jones_J");
        personController.createBuyer(newBuyerDto);
        response = personController.updateBuyer("Cooper_B@gmail.com", existingBuyerDto);
    }

    @And("^there exists a buyer with username <user_name> and email <user_email>$")
    public void thereExistsABuyerWithUsernameAndEmail(String arg0, String arg1){
        BuyerDto existingBuyerDto = new BuyerDto();
        existingBuyerDto.setUserName(arg0);
        existingBuyerDto.setEmail(arg1);
        personController.createBuyer(existingBuyerDto);
        BuyerDto newBuyerDto = new BuyerDto();
        newBuyerDto.setEmail("Cooper_B@gmail.com");
        newBuyerDto.setUserName("Jones_J");
        personController.createBuyer(newBuyerDto);
        response = personController.updateBuyer("Cooper_B@gmail.com", existingBuyerDto);
    }

    @Given("a buyer wants to edit their buyer profile within the  PeaceOfMinde Management System")
    public void aBuyerWantsToEditTheirBuyerProfileWithinThePeaceOfMindeManagementSystemUser_type() {
        BuyerDto dto = new BuyerDto();
        dto.setPassword("hello123");
        dto.setEmail("hello@gmail.com");
        dto.setUserName("hello");
        personController.createBuyer(dto);
        response = personController.updateBuyer("hello@gmail.com", dto);
    }

    @When("a buyer {string} requests to edit their buyer profile with a unique email {string} and a {string}")
    public void aBuyerUser_nameRequestsToEditTheirBuyerProfileWithAUniqueEmailUser_emailAndAUser_passwordAndUser_name(String arg0, String arg1, String arg2) {
        BuyerDto dto = new BuyerDto();
        dto.setUserName(arg0);
        BuyerDto updatedDto = new BuyerDto();
        updatedDto.setEmail(arg1);
        updatedDto.setPassword(arg2);
        response = personController.updateBuyer(arg1, updatedDto);
    }

    @Then("the {string} and {string} is updated")
    public void theUser_nameUser_emailAndUser_passwordIsUpdated(String arg0, String arg1) {
        assertThat(response.getBody().toString().contains(arg0));
        assertThat(response.getBody().toString().contains(arg1));
    }

    @Given("an existing buyer who inputs a username {string}, email {string}, and password {string}")
    public void anExistingBuyerWhoInputsAUsernameUser_nameEmailUser_emailAndPasswordUser_password(String arg0, String arg1, String arg2) {
        BuyerDto existingBuyerDto = new BuyerDto();
        existingBuyerDto.setUserName(arg0);
        existingBuyerDto.setEmail(arg1);
        existingBuyerDto.setPassword(arg2);
        personController.createBuyer(existingBuyerDto);
        BuyerDto newBuyerDto = new BuyerDto();
        newBuyerDto.setEmail("Cooper_B@gmail.com");
        newBuyerDto.setUserName("Jones_J");
        personController.createBuyer(newBuyerDto);
        response = personController.updateBuyer("Cooper_B@gmail.com", existingBuyerDto);
    }

    @And("the {string} and {string} do not follow the correct format")
    public void theUser_emailAndUser_passwordDoNotFollowTheCorrectFormat(String arg0, String arg1) {
        BuyerDto dto = new BuyerDto();
        dto.setEmail(arg0);
        dto.setPassword(arg1);
        response = personController.updateBuyer(arg0, dto);
    }

    @Then("a message {string} is issued")
    public void aMessageMessageIsIssued(String arg0) {
        String exception = (String) response.getBody();
        assertThat(exception).isEqualTo(arg0);
    }

    @And("there exists a buyer with username {string} and email {string} in the PeaceOfMinde Management System")
    public void thereExistsABuyerWithUsernameUser_nameAndEmailUser_email(String arg0, String arg1) {
        BuyerDto dto = new BuyerDto();
        dto.setUserName(arg0);
        dto.setEmail(arg1);
        response = personController.getBuyer(arg1);
        assertThat(response.getBody().toString().contains(arg0));
        assertThat(response.getBody().toString().contains(arg1));
    }

    @And("the buyer account is not updated")
    public void theBuyerAccountIsNotUpdated() {
        assertThat(response.getBody().toString().contains("400"));
    }

}

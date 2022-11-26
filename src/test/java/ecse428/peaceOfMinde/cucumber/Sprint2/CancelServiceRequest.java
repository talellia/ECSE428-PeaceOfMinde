package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class CancelServiceRequest extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;



    @Given("Existing buyer cancels existing service request")
    public void existingBuyerCancelsExistingServiceRequest() {
    }

    @When("A service request cancellation is generated")
    public void aServiceRequestCancellationIsGenerated() {

    }

    @Then("The service request should be removed from the database")
    public void theServiceRequestShouldBeRemovedFromTheDatabase() {

    }

    @Given("Existing buyer cancels non-existing service request")
    public void existingBuyerCancelsNonExistingServiceRequest() {

    }

    @Then("The service request should not be removed from the database")
    public void theServiceRequestShouldNotBeRemovedFromTheDatabase() {

    }

    @And("An error message is issued to buyer")
    public void anErrorMessageIsIssuedToBuyer() {
    }
}

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

public class CreateServiceRequestStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;

    @When("A service request creation is generated")
    public void aServiceRequestCreationIsGenerated() {
    }

    @Given("An existing buyer inputs a service request with {string}, {string}, {int}.")
    public void anExistingBuyerInputsAServiceRequestWithHourlySalary(String title, String description, int hourlysalary) {
    }

    @Then("The service request should be added to the database")
    public void theServiceRequestShouldBeAddedToTheDatabase() {

    }

    @Then("The service request should not be added to the database")
    public void theServiceRequestShouldNotBeAddedToTheDatabase() {

    }

    @And("An error message is displayed with each invalid field")
    public void anErrorMessageIsDisplayedWithEachInvalidField() {
    }
}

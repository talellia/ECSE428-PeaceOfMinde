package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BuyerProfilePageStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;

    /*
        NOTE : most of the stepdefs are defined in the BuyerAccountPageStepDefs.
               If this happens to not work or you need a different setup, change the wording in the .feature file
               and create the new stepdef below
     */

    @When("the Buyer clicks the My Profile button")
    public void theBuyerClicksTheMyAccountButton() {

    }

    @Then("the Buyer Profile Page is displayed")
    public void theBuyerProfilePageIsDisplayed() {
    }
}

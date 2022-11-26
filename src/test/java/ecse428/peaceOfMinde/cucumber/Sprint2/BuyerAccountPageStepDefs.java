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

public class BuyerAccountPageStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;

    @Given("the Buyer is on the home page")
    public void theBuyerIsOnTheHomePage() {

    }

    @And("the Buyer is logged in")
    public void theBuyerIsLoggedIn() {
        
    }

    @When("the Buyer clicks the My Account button")
    public void theBuyerClicksTheMyAccountButton() {
        
    }

    @Then("the Buyer Account Page is displayed")
    public void theBuyerAccountPageIsDisplayed() {
        
    }

    @And("the Buyer is logged out")
    public void theBuyerIsLoggedOut() {
        
    }

    @Then("the LoginSignup page is displayed.")
    public void theLoginSignupPageIsDisplayed2() {
    }


}

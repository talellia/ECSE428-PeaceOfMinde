package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class WorkerAccountPageStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;


    @Given("the Worker is on the home page")
    public void theBuyerIsOnTheHomePage() {

    }

    @And("the Worker is logged in")
    public void theWorkerIsLoggedIn() {

    }

    @When("the Worker clicks the My Account button")
    public void theWorkerClicksTheMyAccountButton() {

    }

    @Then("the Worker Account Page is displayed")
    public void theWorkerAccountPageIsDisplayed() {

    }

    @And("the Worker is logged out")
    public void theWorkerIsLoggedOut() {

    }

    @Then("the LoginSignup page is displayed")
    public void theLoginSignupPageIsDisplayed() {
    }
}

package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInForWorkerPageStepDefs extends SpringIntegrationTest {

    /*
        Note : have a look at the SignUpBuyer and SignUpWorker stepDefs in Sprint1 -> might have some good tips
               This feature is more UI given the backend was already completed in Sprint 1 so maybe take inspo from this
               https://www.baeldung.com/cucumber-spring-integration
     */
    
    @Given("an account with the username {string} exists in the system")
    public void anAccountWithTheUsernameExistsInTheSystem(String arg0) {

    }


    @And("an account with the email address {string} exists in the system")
    public void anAccountWithTheEmailAddressExistsInTheSystem(String arg0) {

    }

    @And("the Worker type sign in portal is clicked")
    public void theWorkerTypeSignInPortalIsClicked() {

    }

    @Given("the email address {string} and password {string} are entered.")
    public void theEmailAddressAndPasswordAreEntered(String arg0, String arg1) {

    }

    @When("I try to click sign in")
    public void iTryToClickSignIn() {

    }

    @Then("a the worker with address {string} dashboard is opened")
    public void aTheWorkerWithAddressDashboardIsOpened(String arg0) {

    }

    @When("I try to click sign up")
    public void iTryToClickSignUp() {

    }

    @And("a message {string} shall be returned to the worker.")
    public void aMessageShallBeReturnedToTheWorker(String arg0) {

    }

    @Given("the email address {string} and password {string} is entered.")
    public void theEmailAddressAndPasswordIsEntered(String arg0, String arg1) {

    }

    @And("there is no account with email address {string} in the system.")
    public void thereIsNoAccountWithEmailAddressInTheSystem(String arg0) {

    }

    @Then("a message {string} shall be returned to the worker")
    public void aMessageShallBeReturnedToTheWorker2(String arg0) {
    }
}

package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInForBuyerPageStepDefs extends SpringIntegrationTest {

    /*
    Note : have a look at the SignUpBuyer and SignUpWorker stepDefs in Sprint1 -> might have some good tips
           This feature is more UI given the backend was already completed in Sprint 1 so maybe take inspo from this
           https://www.baeldung.com/cucumber-spring-integration
     */


    @Given("the following buyers already exist in the system:")
    public void theFollowingBuyersAlreadyExistInTheSystem(DataTable table) {
    }


    @Given("the email address {string} and password {string} are entered")
    public void theEmailAddressAndPasswordAreEntered(String arg0, String arg1) {

    }

    @When("user tries to click sign in")
    public void userTriesToClickSignIn() {

    }

    @Then("a the buyer with address {string} dashboard is opened")
    public void aTheBuyerWithAddressDashboardIsOpened(String arg0) {

    }

    @When("user tries to click sign up")
    public void userTriesToClickSignUp() {

    }

    @And("a message {string} shall be returned.")
    public void aMessageShallBeReturned(String arg0) {

    }

    @Given("the email address {string} and password {string} is entered")
    public void theEmailAddressAndPasswordIsEntered(String arg0, String arg1) {

    }

    @And("there is no account with email address {string} in the system")
    public void thereIsNoAccountWithEmailAddressInTheSystem(String arg0) {
    }
}

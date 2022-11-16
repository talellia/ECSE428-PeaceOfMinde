package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ChangePasswordStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;


    /*
        Please look at the step defs from Sprint1 called ChangePasswordBuyer and ChangePasswordWorker
     */


    @Given("the following users exist in the system:")
    public void theFollowingUsersExistInTheSystem(DataTable table) {
    }


    @Given("the user with  email address {string} and password {string} is logged in to the system")
    public void theUserWithEmailAddressEmailAddressAndPasswordPasswordIsLoggedInToTheSystem(String email, String password) {

    }

    @Then("users new password is {string}")
    public void usersNewPasswordIsNewPassword(String newPassword) {
    }

    @Then("a message {string} shall be returned to the user")
    public void aMessageMessageShallBeReturnedToTheUser(String message) {
    }

    @When("user tries to click change password with {string}")
    public void userTriesToClickChangePasswordWith(String arg0) {

    }

}

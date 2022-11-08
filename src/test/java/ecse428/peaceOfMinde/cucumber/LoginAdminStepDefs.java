package ecse428.peaceOfMinde.cucumber;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.dao.AdminRepository;
import ecse428.peaceOfMinde.dto.AdminDto;
import ecse428.peaceOfMinde.model.Admin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAdminStepDefs extends SpringIntegrationTest{

    @Autowired
    private PersonController personController;
    @Autowired
    private AdminRepository adminRepository;


    private ResponseEntity<?> response;
   @Given("^the following Admins exist:$")
    public void followingAdminsExist(DataTable table)
   {
       List<List<String>> rows = table.asLists(String.class);
       rows.stream().skip(1).forEach(columns->{
           Admin temp = new Admin();
           temp.setUsername(columns.get(0));
           temp.setEmail(columns.get(1));
           temp.setPassword(columns.get(2));
           temp.setId(Integer.parseInt(columns.get(3)));
           adminRepository.save(temp);
       } );
   }

    @When("a request to login is issued with email {string} and password {string}")
    public void aRequestToLoginIsIssuedWithEmailAndPassword(String arg0, String arg1) {
        AdminDto dto = AdminDto.builder().email(arg0).password(arg1).build();
        response = personController.loginAdminByEmail(dto);
    }

    @Then("Admin with id {string} is logged in")
    public void adminWithIdIsLoggedIn(String arg0) {
        assertThat(response.getBody()).isInstanceOf(AdminDto.class);
    }


    @When("a request to login is issued with user name {string} and password {string}")
    public void aRequestToLoginIsIssuedWithUserNameAttempt_user_nameAndPasswordAttempt_password(String username, String password) {
        AdminDto dto = AdminDto.builder().userName(username).password(password).build();
        response = personController.loginAdminByUsername(dto);
    }

    @Then("login fails")
    public void loginFails() {
        assertThat(response.getBody()).isInstanceOf(String.class);
    }

    @And("the error message {string} is issued")
    public void theErrorMessageIsIssued(String arg0) {
       String exception = (String) response.getBody();
       assertThat(exception).isEqualTo(arg0);
    }

    @When("a request to login is issued with username {string} and password {string}")
    public void aRequestToLoginIsIssuedWithUsernameAndPassword(String arg0, String arg1) {
        AdminDto dto = AdminDto.builder().userName(arg0).password(arg1).build();
        response = personController.loginAdminByUsername(dto);
    }

}

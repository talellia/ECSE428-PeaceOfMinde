package ecse428.peaceOfMinde.cucumber.Sprint2;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.ServiceOfferingRepository;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.ServiceOfferingDto;
import ecse428.peaceOfMinde.model.ServiceOffering;
import ecse428.peaceOfMinde.service.PersonService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewAllServiceRequestsAsWorkerStepDefs extends SpringIntegrationTest {

  
    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private ServiceOfferingRepository serviceOfferingRepository;
    
    private ResponseEntity<?> response;
    
    @Given("the following service requests exist:")
    public void theWorkerIdentifiedById(DataTable table) {
      
      List<List<String>> rows = table.asLists(String.class);
      rows.stream().skip(1).forEach(columns->{
          ServiceOffering temp = new ServiceOffering();
          temp.setHourlySalary(Double.parseDouble(columns.get(0)));
          temp.setTitle(columns.get(1));
          temp.setId(Integer.parseInt(columns.get(2)));
          serviceOfferingRepository.save(temp);
      } );
    }

    @When("The worker clicks on the Services Request Page")
    public void theWorkerClicksOnTheServicesRequestPage() {
      
      ServiceOfferingDto serviceOfferingDto = new ServiceOfferingDto();
      response = personController.viewServiceOfferingsWorker(serviceOfferingDto);
    }

    @Then("a maximum of {int} queries from the database should be displayed to the worker")
    public void theServicesRequestUpToQueriesFromTheDatabaseShouldAppearOnThePage(int arg0) {
      
      assertThat(response.getBody()).isInstanceOf(String.class);
      assertThat(serviceOfferingRepository.count() < arg0);
    }

    @Given("the following service requests exist with hourlySalary:")
    public void theWorkerIdentifiedByIdInputsAServiceQueryWithOrAndHourlySalary(DataTable table) {
      
      List<List<String>> rows = table.asLists(String.class);
      rows.stream().skip(1).forEach(columns->{
          ServiceOffering temp = new ServiceOffering();
          temp.setHourlySalary(Double.parseDouble(columns.get(0)));
          temp.setTitle(columns.get(1));
          temp.setId(Integer.parseInt(columns.get(2)));
          serviceOfferingRepository.save(temp);
      } );
    }

    @When("The worker conducts a service request with hourlySalary {String}")
    public void theServiceRequestIsSearched(String salary) {
      
      ServiceOfferingDto serviceOfferingDto = new ServiceOfferingDto();
      response = personController.viewServiceOfferingsByHourlyRate(serviceOfferingDto, Integer.parseInt(salary));
    }

    @Then("Up to {int} valid services from the database should appear on the page")
    public void theServicesRequestWithUpToQueriesFromTheDatabaseShouldAppearOnThePage(int arg0) {
      
      assertThat(response.getBody()).isInstanceOf(String.class);
    }


    @Given("The following service requests exist with serviceOffering IDs:")
    public void theWorkerSearchesForAnOfferingThatDoesntExist(DataTable table) {
      
      List<List<String>> rows = table.asLists(String.class);
      rows.stream().skip(1).forEach(columns->{
          ServiceOffering temp = new ServiceOffering();
          temp.setId(Integer.parseInt(columns.get(0)));
          temp.setTitle(columns.get(1));
          serviceOfferingRepository.save(temp);
      } );
    }
    
    @When("The worker searches for a service offering with id {String}")
    public void theServiceRequestIsSearchedWrong(String id) {
      
      response = personController.getWorkerServiceOffering(Integer.parseInt(id));
    }
    
    @Then("The service request fails")
    public void theServiceRequestFails() {
      
      assertThat(response.getBody()).isInstanceOf(String.class);
    }
    
    @And("the error message {String} is issued to worker")
    public void anErrorMessageIsShownToWorker(String arg0) {
      
      String exception = (String) response.getBody();
      assertThat(exception).isEqualTo(arg0);
    }

    
}

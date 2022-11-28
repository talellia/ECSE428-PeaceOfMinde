package ecse428.peaceOfMinde.cucumber.Sprint2;

import ecse428.peaceOfMinde.controller.BuyerController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dao.ServiceOfferingRepository;
import ecse428.peaceOfMinde.dto.*;
import ecse428.peaceOfMinde.model.*;
import ecse428.peaceOfMinde.utility.PersonException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import javax.security.auth.PrivateCredentialPermission;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateServiceRequestStepDefs extends SpringIntegrationTest {

    @Autowired
    private BuyerController buyerController;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private ServiceOfferingRepository serviceRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;
    private ServiceOfferingDto serviceOfferDto;
    private int id; 

    @Given("An existing buyer inputs a valid service request with {string}, {string}, {int}.")
    public void anExistingBuyerInputsAValidServiceRequestWithHourlySalary(String title, String description, int hourlysalary) {
        ServiceOffering serviceOffering = new ServiceOffering(); 
        serviceOffering.setTitle("title");
        serviceOffering.setDescription("description");
        serviceOffering.setHourlySalary(hourlysalary);
        serviceOffering.setId(1);
        serviceRepository.save(serviceOffering);

        id = serviceOffering.getId();
       
        serviceOfferDto = new ServiceOfferingDto();
        serviceOfferDto.setTitle("title");
        serviceOfferDto.setDescription("description");
        serviceOfferDto.setHourlySalary(hourlysalary);
    }

    @Given("An existing buyer inputs an invalid service request with {string}, {string}, {int}.")
    public void anExistingBuyerInputsAnInvalidServiceRequestWithHourlySalary(String title, String description, int hourlysalary) {
        ServiceOffering serviceOffering = new ServiceOffering(); 
        serviceOffering.setTitle("title");
        serviceOffering.setDescription("description");
        serviceOffering.setHourlySalary(hourlysalary);
        serviceOffering.setId(2);
        serviceRepository.save(serviceOffering);

        id = serviceOffering.getId();
       
        serviceOfferDto = new ServiceOfferingDto();
        serviceOfferDto.setTitle("title");
        serviceOfferDto.setDescription("description");
        serviceOfferDto.setHourlySalary(hourlysalary);
    }

    @When("A service request creation is generated")
    public void aServiceRequestCreationIsGenerated() throws PersonException {
        buyerDto = new BuyerDto();
        response = buyerController.createServiceOffering(buyerDto, serviceOfferDto);
    }

    @Then("The service request should be added to the database")
    public void theServiceRequestShouldBeAddedToTheDatabase() {
        Optional<ServiceOffering> serviceOffering = serviceRepository.findById(id);
        assertThat(serviceOffering.isPresent()).isTrue();
    }

    @Then("The service request should not be added to the database")
    public void theServiceRequestShouldNotBeAddedToTheDatabase() {
        Optional<ServiceOffering> serviceOffering = serviceRepository.findById(id);
        assertThat(serviceOffering.isPresent()).isFalse();
    }
}

package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AboutMeSectionWorkerStepDefs extends SpringIntegrationTest {

    @Autowired
    private PersonController personController;
    @Autowired
    private WorkerRepository workerRepository;

    private ResponseEntity<?> response;

    private WorkerDto workerDto;

    @Given("The worker identified by {int} inputs a valid {string} description")
    public void workerIdentifiedByIdInputsValidAboutMeDescprition(Integer integer, String description) {
        Worker worker = new Worker();
        worker.setFirstName("firstName");
        worker.setLastName("lastName");
        worker.setResidentialAddress("address");
        worker.setUsername("username");
        worker.setEmail("email@mail.com");
        worker.setPassword("password");
        workerRepository.save(worker);


        workerDto = new WorkerDto();
        workerDto.setFirstName("firstName");
        workerDto.setLastName("lastName");
        workerDto.setResidentialAddress("address");
        workerDto.setUserName("username");
        workerDto.setEmail("email@mail.com");
        workerDto.setPassword("password");
        workerDto.setAbout(description);
    }

    @When("An add about me section request is generated for the worker")
    public void anAddAboutMeSectionRequestIsGeneratedForTheWorker() {
        response = personController.updateWorker(workerDto.getEmail(),workerDto);
    }

    @Then("The about me description should be added to the database for the worker")
    public void theAboutMeDescriptionShouldBeAddedToTheDatabaseForTheWorker() {
        Optional<Worker> worker = workerRepository.findWorkerByEmail(workerDto.getEmail());
        assertThat(worker.isPresent()).isTrue();
        assertThat(worker.get().getAboutme()==null).isFalse();
    }

    @Given("A worker that cannot be identified by {int} inputs an {string} description")
    public void aWorkerThatCannotBeIdentifiedByIdInputsAnDescription(Integer id, String description) {
        Worker worker = new Worker();
        worker.setFirstName("firstName");
        worker.setLastName("lastName");
        worker.setResidentialAddress("address");
        worker.setUsername("username");
        worker.setEmail("email@mail.com");
        worker.setPassword("password");
        workerRepository.save(worker);


        workerDto = new WorkerDto();
        workerDto.setFirstName("firstName");
        workerDto.setLastName("lastName");
        workerDto.setResidentialAddress("address");
        workerDto.setUserName("username");
        workerDto.setEmail("DIFFERENT_EMAIL@mail.com");
        workerDto.setPassword("password");
        workerDto.setAbout(description);
    }

    @Then("The about me description should not be added to the database for the worker")
    public void theAboutMeDescriptionShouldNotBeAddedToTheDatabaseForTheWorker() {
        Optional<Worker> worker = workerRepository.findWorkerByEmail(workerDto.getEmail());
        assertThat(worker.isPresent()).isFalse();
        Optional<Worker> workerExistent = workerRepository.findWorkerByEmail("email@mail.com");
        assertThat(workerExistent.isPresent()).isTrue();
        assertThat(workerExistent.get().getAboutme()==null).isTrue();
    }
}
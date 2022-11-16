package ecse428.peaceOfMinde.cucumber.Sprint1;

import ecse428.peaceOfMinde.controller.PersonController;
import ecse428.peaceOfMinde.cucumber.SpringIntegrationTest;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.model.Buyer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AboutMeSectionBuyerStepDefs extends SpringIntegrationTest {
    @Autowired
    private PersonController personController;
    @Autowired
    private BuyerRepository buyerRepository;

    private ResponseEntity<?> response;

    private BuyerDto buyerDto;

    @Given("The buyer identified by {int} inputs a valid {string} description")
    public void buyerIdentifiedByIdInputsValidAboutMeDescprition(Integer integer, String description){
        Buyer buyer = new Buyer();
        buyer.setFirstName("firstName");
        buyer.setLastName("lastName");
        buyer.setResidentialAddress("address");
        buyer.setUsername("username");
        buyer.setEmail("email@mail.com");
        buyer.setPassword("password");
        buyerRepository.save(buyer);

        buyerDto = new BuyerDto();
        buyerDto.setFirstName("firstName");
        buyerDto.setLastName("lastName");
        buyerDto.setResidentialAddress("address");
        buyerDto.setUserName("username");
        buyerDto.setEmail("email@mail.com");
        buyerDto.setPassword("password");
        buyerDto.setAbout(description);
    }

    @When("An add about me section request is generated")
    public void anAddAboutMeSectionRequestIsGenerated() {
        response = personController.updateBuyer(buyerDto.getEmail(),buyerDto);
    }

    @Then("The about me description should be added to the database for the buyer")
    public void theAboutMeDescriptionShouldBeAddedToTheDatabaseForTheBuyer() {
       Optional<Buyer> buyer = buyerRepository.findBuyerByEmail(buyerDto.getEmail());
       assertThat(buyer.isPresent()).isTrue();
       assertThat(buyer.get().getAboutme()==null).isFalse();
    }

    @Given("An buyer that cannot be identified by {int} inputs an {string} description")
    public void anBuyerThatCannotBeIdentifiedByIdInputsAnDescription(Integer id,String arg) {
        Buyer buyer = new Buyer();
        buyer.setFirstName("firstName");
        buyer.setLastName("lastName");
        buyer.setResidentialAddress("address");
        buyer.setUsername("username");
        buyer.setEmail("email@mail.com");
        buyer.setPassword("password");
        buyerRepository.save(buyer);

        buyerDto = new BuyerDto();
        buyerDto.setFirstName("firstName");
        buyerDto.setLastName("lastName");
        buyerDto.setResidentialAddress("address");
        buyerDto.setUserName("username");
        buyerDto.setEmail("DIFFERENT_EMAIL@mail.com");
        buyerDto.setPassword("password");
        buyerDto.setAbout(arg);
    }

    @Then("The about me description should not be added to the database for the buyer")
    public void theAboutMeDescriptionShouldNotBeAddedToTheDatabaseForTheBuyer() {
        Optional<Buyer> buyer = buyerRepository.findBuyerByEmail(buyerDto.getEmail());
        assertThat(buyer.isPresent()).isFalse();
        Optional<Buyer> buyerExistent = buyerRepository.findBuyerByEmail("email@mail.com");
        assertThat(buyerExistent.isPresent()).isTrue();
        assertThat(buyerExistent.get().getAboutme()==null).isTrue();
    }
}

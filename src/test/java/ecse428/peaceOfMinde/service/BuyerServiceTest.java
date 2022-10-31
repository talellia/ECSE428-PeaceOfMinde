package ecse428.peaceOfMinde.service;

import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.Worker;
import ecse428.peaceOfMinde.utility.PersonException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles(value = {"test"})
class BuyerServiceTest {

    @Mock
    private WorkerRepository workerRepository;

    @Mock
    private BuyerRepository buyerRepository;

    private BuyerService buyerService;
    @BeforeEach
    void setUp() {
        buyerService = new BuyerService(buyerRepository,workerRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createComment() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address", "about me", Collections.emptyList());
        Worker savedWorker = new Worker(1,"firstName", "lastName","address","about me");
        savedBuyer.setListComments(new ArrayList<>());
        when(buyerRepository.findById(any())).thenReturn(Optional.of(savedBuyer));
        when(workerRepository.findById(any())).thenReturn(Optional.of(savedWorker));

        Buyer updatedBuyer = buyerService.createComment(savedBuyer.getId(),savedWorker.getId(),"comment1");

        assertThat(updatedBuyer.getListComments().size()).isEqualTo(1);
    }

    @Test
    void createComment_error_commentIsEmpty(){
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address", "about me", Collections.emptyList());
        Worker savedWorker = new Worker(1,"firstName", "lastName","address","about me");

        when(buyerRepository.findById(any())).thenReturn(Optional.of(savedBuyer));
        when(workerRepository.findById(any())).thenReturn(Optional.of(savedWorker));

        assertThrows(PersonException.class, ()->buyerService.createComment(savedBuyer.getId(),savedWorker.getId(),""));
    }

    @Test
    void createComment_error_buyerDoesntExist() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address", "about me", Collections.emptyList());
        Worker savedWorker = new Worker(1,"firstName", "lastName","address","about me");

        when(buyerRepository.findById(savedBuyer.getId())).thenReturn(Optional.empty());
        when(workerRepository.findById(any())).thenReturn(Optional.of(savedWorker));

        assertThrows(PersonException.class, ()->buyerService.createComment(savedBuyer.getId(),savedWorker.getId(),"comment"));
    }

    @Test
    void createComment_error_workerDoesntExist() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address", "about me", Collections.emptyList());
        Worker savedWorker = new Worker(1,"firstName", "lastName","address","about me");

        when(buyerRepository.findById(any())).thenReturn(Optional.of(savedBuyer));
        when(workerRepository.findById(savedWorker.getId())).thenReturn(Optional.empty());

        assertThrows(PersonException.class, ()->buyerService.createComment(savedBuyer.getId(),savedWorker.getId(),"comment"));
    }
}
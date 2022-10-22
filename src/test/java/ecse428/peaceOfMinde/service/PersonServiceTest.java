package ecse428.peaceOfMinde.service;

import ecse428.peaceOfMinde.dao.AdminRepository;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.AdminDto;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Admin;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.Worker;
import ecse428.peaceOfMinde.utility.PersonException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.nio.BufferOverflowException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles(value = {"test"})
class PersonServiceTest {
    @Mock
    private WorkerRepository workerRepository;

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private AdminRepository adminRepository;

    private PersonService personService;

    private final BuyerDto buyerDto= new BuyerDto("firstName", "lastName","username","password","email@email.com","address");
    private final WorkerDto workerDto= new WorkerDto("firstName", "lastName","username","password","email@email.com","address");
    private final AdminDto adminDto= new AdminDto("firstName", "lastName","username","password","email@email.com","address");


    @BeforeEach
    void setUp() {
        personService = new PersonService(workerRepository,buyerRepository,adminRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createBuyer() throws PersonException {
        Buyer buyer = personService.createBuyer("firstName", "lastName","username","password","email@email.com","address");
        verify(buyerRepository).save(any());
        assertThat(buyer.getFirstName()).isEqualTo("firstName");
    }

    @Test
    void loginBuyer() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        savedBuyer.setPassword("password");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(savedBuyer);
        Buyer buyer = personService.loginBuyer("email", "password");
        assertThat(buyer.getFirstName()).isEqualTo(savedBuyer.getFirstName());
    }

    @Test
    void failLoginBuyer_UserDoesntExist(){
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        savedBuyer.setPassword("password");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(null);
        assertThrows(PersonException.class, () -> personService.loginBuyer("email", "password"));
    }

    @Test
    void failLoginBuyer_WrongPassword(){
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        savedBuyer.setPassword("password");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(savedBuyer);
        assertThrows(PersonException.class, () -> personService.loginBuyer("email", "WrongPassword"));
    }

    @Test
    void getBuyer() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(savedBuyer);
        Buyer buyer = personService.getBuyer("email");
        assertThat(buyer.getFirstName()).isEqualTo(savedBuyer.getFirstName());
    }

    @Test
    void updateBuyer() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(savedBuyer);
        Buyer buyer = personService.updateBuyer("email", buyerDto);
        verify(buyerRepository).save(any());
        assertThat(buyer.getEmail()).isEqualTo(buyerDto.getEmail());
    }

    @Test
    void deleteBuyer() throws PersonException {
        Buyer savedBuyer = new Buyer(1,"firstName", "lastName","address");
        when(buyerRepository.findBuyerByEmail("email")).thenReturn(savedBuyer);
        Buyer buyer = personService.deleteBuyer("email");
        verify(buyerRepository).deleteById(any());
        assertThat(buyer.getFirstName()).isEqualTo(savedBuyer.getFirstName());
    }

    @Test
    void getAllBuyers() {
        List<Buyer> buyer = personService.getAllBuyers();
        verify(buyerRepository).findAll();
        assertThat(buyer.size()).isEqualTo(0);
    }

    @Test
    void createWorker() throws PersonException {
        Worker worker = personService.createWorker("firstName", "lastName","username","password","email@email.com","address");
        verify(workerRepository).save(any());
        assertThat(worker.getFirstName()).isEqualTo("firstName");
    }

    @Test
    void loginWorker() throws PersonException {
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        savedWorker.setPassword("password");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(savedWorker);
        Worker worker = personService.loginWorker("email", "password");
        assertThat(worker.getFirstName()).isEqualTo(savedWorker.getFirstName());
    }

    @Test
    void failLoginWorker_UserDoesntExist(){
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        savedWorker.setPassword("password");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(null);
        assertThrows(PersonException.class, () -> personService.loginWorker("email", "password"));
    }

    @Test
    void failLoginWorker_WrongPassword(){
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        savedWorker.setPassword("password");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(savedWorker);
        assertThrows(PersonException.class, () -> personService.loginWorker("email", "WrongPassword"));
    }

    @Test
    void getWorker() throws PersonException {
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(savedWorker);
        Worker worker = personService.getWorker("email");
        assertThat(worker.getFirstName()).isEqualTo(savedWorker.getFirstName());
    }

    @Test
    void updateWorker() throws PersonException {
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(savedWorker);
        Worker worker = personService.updateWorker("email", workerDto);
        verify(workerRepository).save(any());
        assertThat(worker.getEmail()).isEqualTo(workerDto.getEmail());
    }

    @Test
    void deleteWorker() throws PersonException {
        Worker savedWorker = new Worker(1,"firstName", "lastName","address");
        when(workerRepository.findWorkerByEmail("email")).thenReturn(savedWorker);
        Worker worker = personService.deleteWorker("email");
        verify(workerRepository).deleteById(any());
        assertThat(worker.getFirstName()).isEqualTo(savedWorker.getFirstName());
    }

    @Test
    void getAllWorkers() {
        List<Worker> worker = personService.getAllWorkers();
        verify(workerRepository).findAll();
        assertThat(worker.size()).isEqualTo(0);
    }
    @Test
    void createAdmin() throws PersonException {
        Admin admin = personService.createAdmin("firstName", "lastName","username","password","email@email.com","address");
        verify(adminRepository).save(any());
        assertThat(admin.getFirstName()).isEqualTo("firstName");
    }

    @Test
    void loginAdmin() throws PersonException {
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        savedAdmin.setPassword("password");
        when(adminRepository.findAdminByEmail("email")).thenReturn(savedAdmin);
        Admin admin = personService.loginAdmin("email", "password");
        assertThat(admin.getFirstName()).isEqualTo(savedAdmin.getFirstName());
    }

    @Test
    void failLoginAdmin_UserDoesntExist(){
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        savedAdmin.setPassword("password");
        when(adminRepository.findAdminByEmail("email")).thenReturn(null);
        assertThrows(PersonException.class, () -> personService.loginAdmin("email", "password"));
    }

    @Test
    void failLoginAdmin_WrongPassword(){
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        savedAdmin.setPassword("password");
        when(adminRepository.findAdminByEmail("email")).thenReturn(savedAdmin);
        assertThrows(PersonException.class, () -> personService.loginAdmin("email", "WrongPassword"));
    }

    @Test
    void getAdmin() throws PersonException {
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        when(adminRepository.findAdminByEmail("email")).thenReturn(savedAdmin);
        Admin admin = personService.getAdmin("email");
        assertThat(admin.getFirstName()).isEqualTo(savedAdmin.getFirstName());
    }

    @Test
    void updateAdmin() throws PersonException {
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        when(adminRepository.findAdminByEmail("email")).thenReturn(savedAdmin);
        Admin admin = personService.updateAdmin("email", adminDto);
        verify(adminRepository).save(any());
        assertThat(admin.getEmail()).isEqualTo(adminDto.email());
    }

    @Test
    void deleteAdmin() throws PersonException {
        Admin savedAdmin = new Admin(1,"firstName", "lastName","address");
        when(adminRepository.findAdminByEmail("email")).thenReturn(savedAdmin);
        Admin admin = personService.deleteAdmin("email");
        verify(adminRepository).deleteById(any());
        assertThat(admin.getFirstName()).isEqualTo(savedAdmin.getFirstName());
    }

    @Test
    void getAllAdmins() {
        List<Admin> admin = personService.getAllAdmins();
        verify(adminRepository).findAll();
        assertThat(admin.size()).isEqualTo(0);
    }
}
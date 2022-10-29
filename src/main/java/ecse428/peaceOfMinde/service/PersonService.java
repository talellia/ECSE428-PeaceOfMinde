package ecse428.peaceOfMinde.service;

import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.model.Worker;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.utility.LibraryUtil;
import ecse428.peaceOfMinde.utility.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle the registration and login of buyers and workers
 * This service also deals with user verification functionality
 *
 * @author Gohar Saqib Fazal
 */
@Service
public class PersonService {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    BuyerRepository buyerRepository;

    /**
     * This method creates a buyer if the input is valid
     *
     * @param firstName          First Name of the buyer
     * @param lastName           Last Name of the buyer
     * @param email              Buyer Email
     * @param username           Buyer Username
     * @param password           Buyer Password
     * @param residentialAddress Buyer Residential Address
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer createBuyer(String firstName, String lastName, String username, String password, String email, String residentialAddress, String about) throws PersonException {
        String error = validateBuyer(firstName, lastName, email, username, password, residentialAddress);

        if (error.length() != 0) {
            throw new PersonException(error);
        }

        String duplicate = checkDuplicateEmail(email);

        if (!duplicate.equalsIgnoreCase("")) {
            throw new PersonException(duplicate);
        }

        Buyer buyer = new Buyer();

        buyer.setFirstName(firstName);
        buyer.setLastName(lastName);
        buyer.setEmail(email);
        buyer.setUsername(username);
        buyer.setPassword(password);
        buyer.setResidentialAddress(residentialAddress);
        buyer.setAbout(about);
        buyerRepository.save(buyer);
        return buyer;

    }

    /**
     * This method logins the buyer into an existing account
     *
     * @param email    Buyer Email
     * @param password Buyer Password
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer loginBuyer(String email, String password) throws PersonException {
        Optional<Buyer> buyerOptional = Optional.ofNullable(buyerRepository.findBuyerByEmail(email));
        if (!buyerOptional.isPresent()) {
            throw new PersonException("Buyer does not exist");
        }
        Buyer buyer = buyerOptional.get();
        if (!buyer.getPassword().equals(password)) {
            throw new PersonException("Incorrect password");
        }
        return buyer;
    }

    /**
     * This method returns buyer credentials corresponding to the specified email
     *
     * @param email Buyer email
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer getBuyer(String email) throws PersonException {
        Optional<Buyer> buyerOptional = Optional.ofNullable(buyerRepository.findBuyerByEmail(email));
        if (!buyerOptional.isPresent()) {
            throw new PersonException("Buyer with this email does not exist");
        }
        return buyerOptional.get();
    }

    /**
     * This method updates the buyer credentials in the user account
     *
     * @param email   Buyer email
     * @param buyerDto Buyer Data Transfer Object
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer updateBuyer(String email, BuyerDto buyerDto) throws PersonException {
        Optional<Buyer> buyerOptional = Optional.ofNullable(buyerRepository.findBuyerByEmail(email));
        if (!buyerOptional.isPresent()) {
            throw new PersonException("The buyer with this email does not exist");
        }
        Buyer buyer = buyerOptional.get();

        String error = validateBuyer(buyerDto.getFirstName(), buyerDto.getLastName(), buyerDto.getEmail(),
                buyerDto.getUserName(), buyerDto.getPassword(),
                buyerDto.getResidentialAddress());
        if (!error.equals("")) {
            throw new PersonException(error);
        }
        //check if email has not been taken
        if (!checkDuplicateEmail(buyerDto.getEmail()).equals("")) {
            throw new PersonException(checkDuplicateEmail(email));
        }
        buyer.setFirstName(buyerDto.getFirstName());
        buyer.setLastName(buyerDto.getLastName());
        buyer.setEmail(buyerDto.getEmail());
        buyer.setUsername(buyerDto.getUserName());
        buyer.setPassword(buyerDto.getPassword());
        buyer.setResidentialAddress(buyerDto.getResidentialAddress());
        buyer.setAbout(buyerDto.getAbout());
        buyerRepository.save(buyer);
        return buyer;
    }
    
    /**
     * Updates the old password for  Buyer with the new requested password
     *
     * @param email           Buyer email
     * @param newpassword     New password for the Buyer
     * @param buyerDto       Buyer Data Transfer Object
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer updateBuyerPassword(String email, String newPassword, BuyerDto buyerDto) throws PersonException {
        Optional<Buyer> buyerOptional = Optional.ofNullable(buyerRepository.findBuyerByEmail(email));
        if (!buyerOptional.isPresent()) {
            throw new PersonException("The buyer with this email does not exist");
        }
        Buyer buyer = buyerOptional.get();

        String error = validateBuyer(buyerDto.getFirstName(), buyerDto.getLastName(), buyerDto.getEmail(),
                buyerDto.getUserName(), buyerDto.getPassword(),
                buyerDto.getResidentialAddress());
        if (!error.equals("")) {
            throw new PersonException(error);
        }
        //check if the old password is the same as the old one
        String oldPassword = buyer.getPassword();
        if (oldPassword.equals(newPassword)) {
            throw new PersonException("Your new password cannot be same as your new password.");
        }

        buyer.setPassword(newPassword);

        buyerRepository.save(buyer);
        return buyer;
    }

    /**
     * This method deletes a buyer account
     *
     * @param email Buyer Email
     * @return buyer
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Buyer deleteBuyer(String email) throws PersonException {
        Optional<Buyer> buyerOptional = Optional.ofNullable(buyerRepository.findBuyerByEmail(email));
        if (!buyerOptional.isPresent()) {
            throw new PersonException("The buyer with the given email does not exist");
        }
        Buyer buyer = buyerOptional.get();
        int id = buyer.getId();
        buyerRepository.deleteById(id);
        return buyer;
    }

    /**
     * This method gets all buyers
     *
     * @return List of all buyers
     */
    @Transactional
    public List<Buyer> getAllBuyers() {
        return LibraryUtil.toList(buyerRepository.findAll());
    }

    /**
     * This method creates a worker if the input is valid
     *
     * @param firstName          First Name of Worker
     * @param lastName           Last Name of Worker
     * @param email              Worker Email
     * @param username           Worker Username
     * @param password           Worker Password
     * @param residentialAddress Worker Residential Address
     * @return worker
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Worker createWorker(String firstName, String lastName, String email, String username, String password,
                                     String residentialAddress, String about_description) throws PersonException {
        String error = validateWorker(firstName, lastName, email, username, password, residentialAddress);

        if (error.length() != 0) {
            throw new PersonException(error);
        }

        String duplicate = checkDuplicateEmail(email);

        if (!duplicate.equalsIgnoreCase("")) {
            throw new PersonException(duplicate);
        }

        Worker worker = new Worker();

        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setEmail(email);
        worker.setUsername(username);
        worker.setPassword(password);
        worker.setResidentialAddress(residentialAddress);
        worker.setAbout(about_description);

        workerRepository.save(worker);
        return worker;

    }

    /**
     * This method logins the worker into an existing account
     *
     * @param email    Worker Email
     * @param password Worker Password
     * @return worker
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Worker loginWorker(String email, String password) throws PersonException {
        Optional<Worker> workerOptional = Optional.ofNullable(workerRepository.findWorkerByEmail(email));
        if (!workerOptional.isPresent()) {
            throw new PersonException("Worker does not exist");
        }
        Worker worker = workerOptional.get();
        if (!worker.getPassword().equals(password)) {
            throw new PersonException("Incorrect password");
        }
        return worker;
    }

    /**
     * This method returns worker credentials corresponding to the specified email
     *
     * @param email Worker Email
     * @return worker
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Worker getWorker(String email) throws PersonException {
        Optional<Worker> workerOptional = Optional.ofNullable(workerRepository.findWorkerByEmail(email));
        if (!workerOptional.isPresent()) {
            throw new PersonException("Worker with this email does not exist");
        }
        return workerOptional.get();
    }

    /**
     * This method updates the worker credentials in the worker account
     *
     * @param email        Worker Email
     * @param workerDto    Worker Data Transfer Object
     * @return worker
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Worker updateWorker(String email, WorkerDto workerDto) throws PersonException {
        Optional<Worker> workerOptional = Optional.ofNullable(workerRepository.findWorkerByEmail(email));
        if (!workerOptional.isPresent()) {
            throw new PersonException("The worker with this email does not exist");
        }
        Worker worker = workerOptional.get();

        String error = validateWorker(workerDto.getFirstName(), workerDto.getLastName(), workerDto.getEmail(), workerDto.getUserName(), workerDto.getPassword(),
                workerDto.getResidentialAddress());
        if (!error.equals("")) {
            throw new PersonException(error);
        }
        //check if email has not been taken
        if (!checkDuplicateEmail(workerDto.getEmail()).equals("")) {
            throw new PersonException(checkDuplicateEmail(email));
        }

        worker.setFirstName(workerDto.getFirstName());
        worker.setLastName(workerDto.getLastName());
        worker.setEmail(workerDto.getEmail());
        worker.setUsername(workerDto.getUserName());
        worker.setPassword(workerDto.getPassword());
        worker.setResidentialAddress(workerDto.getResidentialAddress());
        worker.setAbout(workerDto.getAbout());
        workerRepository.save(worker);
        return worker;
    }

    /**
     * This method deletes a worker account
     *
     * @param email Worker Email
     * @return worker
     * @throws PersonException Prints out the error message if the user could not be created
     */
    @Transactional
    public Worker deleteWorker(String email) throws PersonException {
        Optional<Worker> workerOptional = Optional.ofNullable(workerRepository.findWorkerByEmail(email));
        if (!workerOptional.isPresent()) {
            throw new PersonException("The Worker with the given email does not exist");
        }
        Worker worker = workerOptional.get();
        int id = worker.getId();
        workerRepository.deleteById(id);
        return worker;
    }
     /** 
     * @param id
     * @return Buyer
     * @throws PersonException
     */
    @Transactional
    public Buyer getBuyerById(Integer id)  throws PersonException {
        Buyer buyer = buyerRepository.findBuyerById(id);
        return buyer;
    }

    
    /** 
     * @param id
     * @return Worker
     * @throws PersonException
     */
    @Transactional
    public Worker getWorkerById(Integer id)  throws PersonException {
        Worker worker = workerRepository.findWorkerById(id);
        return worker;

    }


    /**
     * This method gets all workers.
     *
     * @return List of all workers
     */
    @Transactional
    public List<Worker> getAllWorkers() {
        return LibraryUtil.toList(workerRepository.findAll());
    }

    // HELPER METHODS

    /**
     * Validates the buyer credentials added during the registration into the Peace of Minde system
     *
     * @param firstName          First Name of Buyer
     * @param lastName           Last Name of Buyer
     * @param email              Buyer Email
     * @param username           Buyer Username
     * @param password           Buyer Password
     * @param residentialAddress Buyer Residential Address
     * @return String telling whether the user credentials are valid
     */
    private String validateBuyer(String firstName, String lastName, String email, String username, String password, String residentialAddress) {
        if (firstName == null || firstName.length() == 0) {
            return "Enter valid first name";
        } else if (lastName == null || lastName.length() == 0) {
            return "Enter valid last name";
        } else if (email == null || email.length() == 0) {
            return "Enter valid email";
        } else if (username == null || username.length() == 0) {
            return "Enter valid username";
        } else if (password == null || password.length() == 0) {
            return "Enter valid password";
        } else if (residentialAddress == null || residentialAddress.length() == 0) {
            return "Enter valid residential address";
        }

        return "";
    }

    /**
     * Validates the worker credentials added during the registration into the Peace of Minde system
     *
     * @param firstName          First Name of Worker
     * @param lastName           Last Name of Worker
     * @param email              Worker Email
     * @param username           Worker Username
     * @param password           Worker password
     * @param residentialAddress Worker Residential Address
     * @return String telling whether the worker credentials are valid
     */
    private String validateWorker(String firstName, String lastName, String email, String username, String password, String residentialAddress) {
        if (firstName == null || firstName.length() == 0) {
            return "Enter valid first name";
        } else if (lastName == null || lastName.length() == 0) {
            return "Enter valid last name";
        } else if (email == null || email.length() == 0) {
            return "Enter valid email";
        } else if (username == null || username.length() == 0) {
            return "Enter valid username";
        } else if (password == null || password.length() == 0) {
            return "Enter valid password";
        } else if (residentialAddress == null || residentialAddress.length() == 0) {
            return "Enter valid residential address";
        }
        return "";
    }

    /**
     * Checks for duplicate emails
     *
     * @param email User Email
     * @return String telling whether an existing user has the given email address in the database
     */
    private String checkDuplicateEmail(String email) {
        if (buyerRepository.findBuyerByEmail(email) == null
                || workerRepository.findWorkerByEmail(email) == null) {
            return "";
        }
        return "Email has already been taken";
    }
}
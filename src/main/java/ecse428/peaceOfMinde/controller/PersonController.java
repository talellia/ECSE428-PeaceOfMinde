package ecse428.peaceOfMinde.controller;

import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.model.Worker;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.service.PersonService;
import ecse428.peaceOfMinde.utility.LibraryUtil;
import ecse428.peaceOfMinde.utility.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the person controller class. It handles the creation, login and
 * validation of the buyer and worker
 *
 * @author Gohar Saqib Fazal
 */
@CrossOrigin(origins = "*")
@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@Autowired
	BuyerRepository buyerRepository;

	// BUYER

	/**
	 * Create Buyer method registers a new buyer into the database
	 *
	 * @param buyerDto Buyer Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/buyer/register", "/person/buyer/register/" })
	public ResponseEntity<?> createBuyer(@RequestBody BuyerDto buyerDto) {
		try {
			Buyer buyer = personService.createBuyer(buyerDto.getFirstName(), buyerDto.getLastName(), buyerDto.getUserName(),
					buyerDto.getPassword(), buyerDto.getEmail(), buyerDto.getResidentialAddress());
			return new ResponseEntity<>(LibraryUtil.convertToDto(buyer), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login Buyer method allows a buyer to log into their account by accessing their
	 * credentials from the database
	 *
	 * @param buyerDto Buyer Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/buyer/login", "/person/buyer/login/" })
	public ResponseEntity<?> loginBuyer(@RequestBody BuyerDto buyerDto) {
		try {
			Buyer buyer = personService.loginBuyer(buyerDto.getEmail(), buyerDto.getPassword());
			return new ResponseEntity<>(LibraryUtil.convertToDto(buyer), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Get Buyer method returns a buyer with all their credentials using the given
	 * email
	 *
	 * @param email Buyer Email
	 * @return Response Entity
	 */
	@GetMapping(value = { "/person/buyer/{email}", "/person/buyer/{email}/" })
	public ResponseEntity<?> getBuyer(@PathVariable String email) {
		try {
			Buyer buyer = personService.getBuyer(email);
			return new ResponseEntity<>(LibraryUtil.convertToDto(buyer), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Update Buyer method updates the information of a specified buyer in the
	 * database
	 *
	 * @param email   Buyer Email
	 * @param buyerDto Buyer Data Transfer Object
	 * @return Response Entity
	 */
	@PutMapping(value = { "/person/buyer/{email}", "/person/buyer/{email}/" })
	public ResponseEntity<?> updateBuyer(@PathVariable String email, @RequestBody BuyerDto buyerDto) {
		try {
			Buyer buyer = personService.updateBuyer(email, buyerDto);
			return new ResponseEntity<>(LibraryUtil.convertToDto(buyer), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete Buyer method deletes a buyer from the database
	 *
	 * @param email Buyer Email
	 * @return Response Entity
	 */
	@DeleteMapping(value = { "/person/buyer/{email}", "/person/buyer/{email}/" })
	public ResponseEntity<?> deleteBuyer(@PathVariable String email) {
		try {
			Buyer buyer = personService.deleteBuyer(email);
			return new ResponseEntity<>("Buyer" + buyer + "has been deleted", HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// WORKER

	/**
	 * Create Worker method registers a new worker into the database
	 *
	 * @param workerDto Worker Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/worker/register", "/person/worker/register/" })
	public ResponseEntity<?> createWorker(@RequestBody WorkerDto workerDto) {
		try {
			Worker worker = personService.createWorker(workerDto.getFirstName(), workerDto.getLastName(),
					workerDto.getEmail(), workerDto.getUserName(), workerDto.getPassword(),
					workerDto.getResidentialAddress(), workerDto.getAbout());
			return new ResponseEntity<>(LibraryUtil.convertToDto(worker), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login Worker method allows a worker to log into their account by
	 * accessing their credentials from the database
	 *
	 * @param workerDto Worker Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/worker/login", "/person/worker/login/" })
	public ResponseEntity<?> loginWorker(@RequestBody WorkerDto workerDto) {
		try {
			Worker worker = personService.loginWorker(workerDto.getEmail(), workerDto.getPassword());
			return new ResponseEntity<>(LibraryUtil.convertToDto(worker), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Get Worker method returns a worker with all their credentials using the
	 * given email
	 *
	 * @param email Worker Email
	 * @return Response Entity
	 */
	@GetMapping(value = { "/person/worker/{email}", "/person/worker/{email}/" })
	public ResponseEntity<?> getWorker(@PathVariable String email) {
		try {
			Worker worker = personService.getWorker(email);
			return new ResponseEntity<>(LibraryUtil.convertToDto(worker), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Update Worker method updates the information of a specified worker in
	 * the database
	 *
	 * @param email        Worker Email
	 * @param workerDto Worker Data Transfer Object
	 * @return Response Entity
	 */
	@PutMapping(value = { "/person/worker/{email}", "/person/worker/{email}/" })
	public ResponseEntity<?> updateWorker(@PathVariable String email, @RequestBody WorkerDto workerDto) {
		try {
			Worker worker = personService.updateWorker(email, workerDto);
			return new ResponseEntity<>(LibraryUtil.convertToDto(worker), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete Worker method deletes a worker from the database
	 *
	 * @param email Worker Email
	 * @return Response Entity
	 */
	@DeleteMapping(value = { "/person/worker/{email}", "/person/worker/{email}/" })
	public ResponseEntity<?> deleteWorker(@PathVariable String email) {
		try {
			Worker worker = personService.deleteWorker(email);
			return new ResponseEntity<>("Worker" + worker + "has been deleted", HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
package ecse428.peaceOfMinde.controller;

import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.dao.WorkerRepository;
import ecse428.peaceOfMinde.dto.AdminDto;
import ecse428.peaceOfMinde.dto.WorkerDto;
import ecse428.peaceOfMinde.dto.BuyerDto;
import ecse428.peaceOfMinde.model.Admin;
import ecse428.peaceOfMinde.model.Worker;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.service.PersonService;
import ecse428.peaceOfMinde.utility.LibraryUtil;
import ecse428.peaceOfMinde.utility.PersonException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is the person controller class. It handles the creation, login and
 * validation of the buyer and worker
 *
 * @author Gohar Saqib Fazal
 */
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;

    private final BuyerRepository buyerRepository;

	private final WorkerRepository workerRepository;

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
					buyerDto.getPassword(), buyerDto.getEmail(), buyerDto.getResidentialAddress(), buyerDto.getAbout() );
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
	 * Updates the old password for  Buyer with the new requested password
	 * in the database
	 * 
	 * @param email  		Buyer email
	 * @param newpassword  	new password to update the old one
	 * @param buyerDto 	Buyer Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/buyer/{newpassword}", "/person/buyer/{newpassword}/" })
	public ResponseEntity<?> updateBuyerPassword(@PathVariable String email,@PathVariable String newpassword, @RequestBody BuyerDto buyerDto) {
		try {

			Buyer buyer = personService.updateBuyerPassword(email,newpassword, buyerDto);
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

	/**
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@GetMapping(value = { "/buyer/{id}", "/buyer/{id}/" })
	public ResponseEntity<?> viewBuyerProfile(@PathVariable Integer id) {
		try {
			Buyer buyer = personService.getBuyerById(id);
			return new ResponseEntity<>(LibraryUtil.convertToDto(buyer), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = { "/person/buyer/approve/{email}", "/person/buyer/approve/{email}/" })
	public ResponseEntity<?> approveBuyer(@PathVariable String email) throws PersonException {
		Buyer buyer = personService.getBuyer(email);
		buyer.setIsRegisteredOnline(true);
		buyerRepository.save(buyer);
		return buyer;
	}

	@PutMapping(value = { "/person/buyer/deny/{email}", "/person/buyer/deny/{email}/" })
	public ResponseEntity<?> denyBuyer(@PathVariable String email) throws PersonException {
		Buyer buyer = personService.getBuyer(email);
		buyer.setIsRegisteredOnline(false);
		buyerRepository.save(buyer);
		return buyer;
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
	 * Updates the old password for  Worker with the new requested password
	 * in the database
	 * 
	 * @param email  		Worker email
	 * @param newpassword  	new password to update the old one
	 * @param workerDto 	Worker Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/worker/{newpassword}", "/person/worker/{newpassword}/" })
	public ResponseEntity<?> updateWorkerPassword(@PathVariable String email,@PathVariable String newpassword, @RequestBody WorkerDto workerDto) {
		try {

			Worker worker = personService.updateWorkerPassword(email,newpassword, workerDto);
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

	/**
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@GetMapping(value = { "/worker/{id}", "/worker/{id}/" })
	public ResponseEntity<?> viewWorkerProfile(@PathVariable Integer id) {
		try {
			Worker worker = personService.getWorkerById(id);
			return new ResponseEntity<>(LibraryUtil.convertToDto(worker), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = { "/person/worker/approve/{email}", "/person/worker/approve/{email}/" })
	public ResponseEntity<?> approveWorker(@PathVariable String email) throws PersonException {
		Worker worker = personService.getWorker(email);
		worker.setIsRegisteredOnline(true);
		workerRepository.save(worker);
		return worker;
	}

	@PutMapping(value = { "/person/worker/deny/{email}", "/person/worker/deny/{email}/" })
	public ResponseEntity<?> denyWorker(@PathVariable String email) throws PersonException {
		Worker worker = personService.getWorker(email);
		worker.setIsRegisteredOnline(false);
		workerRepository.save(worker);
		return worker;
	}



	// ADMIN


	/**
	 * Create Admin method registers a new admin into the database
	 *
	 * @param adminDto Admin Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/admin/register", "/person/admin/register/" })
	public ResponseEntity<?> createAdmin(@RequestBody AdminDto adminDto) {
		try {
			Admin admin = personService.createAdmin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getUserName(),
					adminDto.getPassword(), adminDto.getEmail(), adminDto.getResidentialAddress());
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login Admin method allows a admin to log into their account by accessing their
	 * credentials from the database
	 *
	 * @param adminDto Admin Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/admin/login", "/person/admin/login/" })
	public ResponseEntity<?> loginAdminByEmail(@RequestBody AdminDto adminDto) {
		try {
			Admin admin = personService.loginAdminByEmail(adminDto.getEmail(), adminDto.getPassword());
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>("Email or password is incorrect. Please try again", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Login Admin method allows a admin to log into their account by accessing their
	 * credentials from the database
	 *
	 * @param adminDto Admin Data Transfer Object
	 * @return Response Entity
	 */
	@PostMapping(value = { "/person/admin/login/username", "/person/admin/login/username" })
	public ResponseEntity<?> loginAdminByUsername(@RequestBody AdminDto adminDto) {
		try {
			Admin admin = personService.loginAdminByUsername(adminDto.getUserName(), adminDto.getPassword());
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>("Username or password is incorrect. Please try again", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Get Admin method returns a admin with all their credentials using the given
	 * email
	 *
	 * @param email Admin Email
	 * @return Response Entity
	 */
	@GetMapping(value = { "/person/admin/{email}", "/person/admin/{email}/" })
	public ResponseEntity<?> getAdmin(@PathVariable String email) {
		try {
			Admin admin = personService.getAdmin(email);
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Update Admin method updates the information of a specified admin in the
	 * database
	 *
	 * @param email   Admin Email
	 * @param adminDto Admin Data Transfer Object
	 * @return Response Entity
	 */
	@PutMapping(value = { "/person/admin/{email}", "/person/admin/{email}/" })
	public ResponseEntity<?> updateAdmin(@PathVariable String email, @RequestBody AdminDto adminDto) {
		try {
			Admin admin = personService.updateAdmin(email, adminDto);
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete Admin method deletes a admin from the database
	 *
	 * @param email Admin Email
	 * @return Response Entity
	 */
	@DeleteMapping(value = { "/person/admin/{email}", "/person/admin/{email}/" })
	public ResponseEntity<?> deleteAdmin(@PathVariable String email) {
		try {
			Admin admin = personService.deleteAdmin(email);
			return new ResponseEntity<>("Admin" + admin + "has been deleted", HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@GetMapping(value = { "/admin/{id}", "/admin/{id}/" })
	public ResponseEntity<?> viewAdminProfile(@PathVariable Integer id) {
		try {
			Admin admin = personService.getAdminById(id);
			return new ResponseEntity<>(LibraryUtil.convertToDto(admin), HttpStatus.OK);
		} catch (PersonException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


}
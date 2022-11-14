package ecse428.peaceOfMinde.controller;

import ecse428.peaceOfMinde.dto.*;
import ecse428.peaceOfMinde.model.*;
import ecse428.peaceOfMinde.service.BuyerService;
import ecse428.peaceOfMinde.utility.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;
    
    @PutMapping(value = { "/person/worker/createServiceOffering", "/person/worker/createServiceOffering" })
	public ResponseEntity<?> createServiceOffering(@RequestBody BuyerDto buyerDto, @RequestBody ServiceOfferingDto serviceOfferingDto) throws PersonException {
		try {
			ServiceOffering serviceOffering = buyerService.createServiceOffering(buyerDto.getId(), serviceOfferingDto.getId(), 
												serviceOfferingDto.getTitle(), serviceOfferingDto.getDescription(),
                								serviceOfferingDto.getHourlySalary(), serviceOfferingDto.getDateCreated());
			return new ResponseEntity<>(LibraryUtil.convertToDto(serviceOffering), HttpStatus.OK);
		} catch (ServiceOfferingException serviceOfferingException) {
			return new ResponseEntity<>(serviceOfferingException.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

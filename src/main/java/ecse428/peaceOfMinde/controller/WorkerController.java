package ecse428.peaceOfMinde.controller;

import ecse428.peaceOfMinde.dto.*;
import ecse428.peaceOfMinde.model.*;
import ecse428.peaceOfMinde.service.BuyerService;
import ecse428.peaceOfMinde.service.WorkerService; // ADD
import ecse428.peaceOfMinde.utility.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService; // TODO
    private final BuyerService buyerService;

    /**
     * View a specific ServiceRequest
     * @param serviceOfferingId - Service Offering ID to View
     * @return
     * @throws PersonException
     */
    @GetMapping(value = { "/person/worker/getServiceOffering", "/person/worker/getServiceOffering" })
    public ResponseEntity<?> getServiceOffering(@RequestBody Integer serviceOfferingId) throws PersonException {
        try {
            ServiceOffering serviceOffering = workerService.getServiceOffering(serviceOfferingId);
            return new ResponseEntity<>(LibraryUtil.convertToDto(serviceOffering), HttpStatus.OK);
        } catch (ServiceOfferingException serviceOfferingException) {
            return new ResponseEntity<>(serviceOfferingException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * View all ServicOfferings from a Buyer
     * @param buyerId
     * @return
     * @throws PersonException
     */
    @GetMapping(value = { "/person/worker/getServiceOffering", "/person/worker/getServiceOffering" })
    public ResponseEntity<?> getAllServiceOfferings(@RequestBody Integer buyerId) throws PersonException {
        try {
            List<ServiceOffering> serviceOfferings = buyerService.getAllServiceOfferings(buyerId);
            List<ServiceOfferingDto> serviceOfferingDtos = new ArrayList<>();

            // Convert all the serviceOfferings to DTOs
            for (int i =0; i<serviceOfferings.size(); i++) {
                ServiceOffering currServiceOffering = serviceOfferings.get(i);
                ServiceOfferingDto serviceOfferDto = LibraryUtil.convertToDto(currServiceOffering);
                serviceOfferingDtos.add(serviceOfferDto);
            }

            return new ResponseEntity<>(serviceOfferingDtos, HttpStatus.OK);
        } catch (ServiceOfferingException serviceOfferingException) {
            return new ResponseEntity<>(serviceOfferingException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package ecse428.peaceOfMinde.service;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ecse428.peaceOfMinde.utility.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ecse428.peaceOfMinde.dao.*;
import ecse428.peaceOfMinde.model.*;
@Service
@AllArgsConstructor
public class WorkerService {

    private final BuyerRepository buyerRepository;
    private final WorkerRepository  workerRepository;
    private final ServiceOfferingRepository  serviceOfferingRepository;

    /**
     * Get all service offerings from a buyerId
     * @param serviceOfferingId id of the buyer offering the services
     * @return
     * @throws PersonException
     */
    public ServiceOffering getServiceOffering(Integer serviceOfferingId) throws ServiceOfferingException {
        Optional<ServiceOffering> optionalServiceOffering = serviceOfferingRepository.findById(serviceOfferingId);

        if (!optionalServiceOffering.isPresent()){
            throw new ServiceOfferingException("The Service offering for this buyer does not exist.");
        }

        ServiceOffering serviceOffering = optionalServiceOffering.get();

        return serviceOffering;
    }

    /**
     * Return the associated buyer of a serviceOffering
     * @param serviceOfferingId id of the service Offering to get
     * @return
     * @throws PersonException
     */
    public Buyer getServiceOfferingBuyer(Integer serviceOfferingId) throws PersonException {
        Optional<ServiceOffering> optionalServiceOffering = serviceOfferingRepository.findById(serviceOfferingId);

        if (!optionalServiceOffering.isPresent()){
            throw new PersonException("The Service offering for this buyer does not exist.");
        }

        ServiceOffering serviceOffering = optionalServiceOffering.get();
        Integer buyerId = serviceOffering.getBuyerId();

        Optional<Buyer> optionalBuyer = buyerRepository.findById(buyerId);

        if (!optionalBuyer.isPresent()){
            throw new PersonException("The Buyer does not exist.");
        }

        Buyer buyer = optionalBuyer.get();

        return buyer;
    }
}

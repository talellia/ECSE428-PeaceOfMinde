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
public class BuyerService {
	private final BuyerRepository buyerRepository;
	private final WorkerRepository  workerRepository;
	private final ServiceOfferingRepository  serviceOfferingRepository;

	/**
	 * Create a comment by a worker on a buyer
	 * @param buyerId
	 * @param workerId
	 * @param comment
	 * @return Updated Buyer
	 * @throws PersonException
	 */
	@Transactional
	public Buyer createComment(Integer buyerId, Integer workerId, String comment) throws PersonException {
		Optional<Buyer> optionalBuyer = buyerRepository.findById(buyerId);
		Optional<Worker> optionalWorker = workerRepository.findById(workerId);

		if (!optionalBuyer.isPresent() || !optionalWorker.isPresent()){
            throw new PersonException("The buyer or the worker does not exist.");
		}
		if (comment.isEmpty()){
			throw new PersonException("There is no comment to submit.");
		}
		Buyer buyer = optionalBuyer.get();
		List<String> comments = buyer.getListComments();
		comments.add(comment);
		buyerRepository.save(buyer);
		return buyer;
	}

		/**
	 * Create a comment by a worker on a buyer
	 * @param buyerId
	 * @param workerId
	 * @param comment
	 * @return Updated Buyer
	 * @throws ServiceOfferingException
	 */
	@Transactional
	public ServiceOffering createServiceOffering(Integer buyerId, Integer id, String title, String description, 
							double hourlySalary, LocalDateTime dateCreated) throws ServiceOfferingException {
		Optional<Buyer> optionalBuyer = buyerRepository.findById(buyerId);

		if (!optionalBuyer.isPresent()){
            throw new ServiceOfferingException("The worker does not exist.");
		}
		else if (title.isEmpty()){
            throw new ServiceOfferingException("There is no title to this job.");
		}
		else if (description.isEmpty()){
			throw new ServiceOfferingException("There is no description to this job.");
		}
		ServiceOffering serviceOffering = new ServiceOffering(buyerId, id, title, description, hourlySalary, dateCreated);
		Buyer buyer = optionalBuyer.get();
		List<Integer> serviceOfferingIds = buyer.getServiceOfferingIds();
		serviceOfferingIds.add(id);
		buyerRepository.save(buyer);
		serviceOfferingRepository.save(serviceOffering);
		return serviceOffering;
	}

}
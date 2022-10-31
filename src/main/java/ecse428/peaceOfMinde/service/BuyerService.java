package ecse428.peaceOfMinde.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ecse428.peaceOfMinde.utility.*;

import java.util.List;
import java.util.Optional;

import ecse428.peaceOfMinde.dao.*;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.*;

@AllArgsConstructor
public class BuyerService {
	private final BuyerRepository buyerRepository;
	private final WorkerRepository  workerRepository;

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

}
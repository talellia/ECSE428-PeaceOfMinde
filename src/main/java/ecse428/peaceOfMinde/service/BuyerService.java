package ecse428.peaceOfMinde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecse428.peaceOfMinde.utility.*;


import java.util.List;
import ecse428.peaceOfMinde.dao.*;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.*;



@Service
public class BuyerService {
	@Autowired
	BuyerRepository buyerRepository;
	WorkerRepository  workerRepository;


	
	/** 
	 * @param email
	 * @return Buyer
	 */
	@Transactional
	public Buyer get(String email) {
		return buyerRepository.findBuyerByEmail(email);
	}

	
	/** 
	 * @param buyer
	 * @param worker
	 * @param comment
	 * @return Buyer
	 * Still need to do error checking to see if worker has done a job for the buyer
	 */
	@Transactional
	public Buyer createComment(Integer buyerId, Integer workerId, String comment) throws PersonException {
		Buyer buyer = buyerRepository.findBuyerById(buyerId);
		Worker worker = workerRepository.findWorkerById(workerId);

		if (workerId == null || buyerId == null){
            throw new PersonException("The buyer or the worker does not exist.");
		}
		if (comment.isEmpty()){
			throw new PersonException("There is no comment to submit.");
		}

		List<String> comments = buyer.getListComments();
		comments.add(comment);
		buyer.setListComments(comments);

		return buyer;
	}

}
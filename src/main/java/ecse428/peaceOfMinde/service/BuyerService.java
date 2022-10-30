package ecse428.peaceOfMinde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecse428.peaceOfMinde.dao.*;
import ecse428.peaceOfMinde.model.Buyer;
import ecse428.peaceOfMinde.model.*;



@Service
public class BuyerService {
	@Autowired
	BuyerRepository buyerRepository;

	@Transactional
	public Buyer get(String email) {
		return buyerRepository.findBuyerByEmail(email);
	}

	@Transactional
	public Buyer createComment(Buyer buyer, Worker worker, String comment) {
		Integer buyerId = buyer.getId();
		Integer workerId = worker.getId();


		return buyer;
	}

}
package ecse428.peaceOfMinde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecse428.peaceOfMinde.dao.BuyerRepository;
import ecse428.peaceOfMinde.model.Buyer;


@Service
public class BuyerService {
	@Autowired
	BuyerRepository buyerRepository;

	@Transactional
	public Buyer get(String email) {
		return buyerRepository.findBuyerByEmail(email);
	}

}
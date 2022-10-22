package ecse428.peaceOfMinde.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ecse428.peaceOfMinde.model.Buyer;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends PagingAndSortingRepository<Buyer, Integer> {
    Buyer findBuyerByEmail(String email);
    Buyer findBuyerById(Integer id);
}
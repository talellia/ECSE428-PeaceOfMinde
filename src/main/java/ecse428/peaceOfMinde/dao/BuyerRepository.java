package ecse428.peaceOfMinde.dao;

import ecse428.peaceOfMinde.model.Buyer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends PagingAndSortingRepository<Buyer, Integer> {
    Optional<Buyer> findBuyerByEmail(String email);
}
package ecse428.peaceOfMinde.dao;

import ecse428.peaceOfMinde.model.ServiceOffering;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOfferingRepository extends PagingAndSortingRepository<ServiceOffering, Integer> {
    
}

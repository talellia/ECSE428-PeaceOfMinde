package ecse428.peaceOfMinde.dao;

import ecse428.peaceOfMinde.model.ServiceOffering;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOfferingRepository extends PagingAndSortingRepository<ServiceOffering, Integer> {
  
  /**
   * Find service offering based on their ID
   */
  ServiceOffering findServiceOfferingByID(int serviceOfferingID);

  /**
   * Find all service offerings for each worker using an hourly rate.
   */

  List<ServiceOffering> findServiceOfferingByHourlyRate(int hourlyRate);
    
}

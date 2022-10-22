package ecse428.peaceOfMinde.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ecse428.peaceOfMinde.model.Worker;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends PagingAndSortingRepository<Worker, Integer> {
    Worker findWorkerByEmail(String email);
}
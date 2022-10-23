package ecse428.peaceOfMinde.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ecse428.peaceOfMinde.model.Worker;

public interface WorkerRepository extends PagingAndSortingRepository<Worker, Integer> {
    Worker findWorkerByEmail(String email);
    Worker findWorkerById(Integer id);

}
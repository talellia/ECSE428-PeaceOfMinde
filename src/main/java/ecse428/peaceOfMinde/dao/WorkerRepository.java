package ecse428.peaceOfMinde.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ecse428.peaceOfMinde.model.Worker;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends PagingAndSortingRepository<Worker, Integer> {
    Optional<Worker> findWorkerByEmail(String email);
    Optional<Worker> findWorkerByUsername(String email);
}
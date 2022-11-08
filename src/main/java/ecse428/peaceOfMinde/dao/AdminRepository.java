package ecse428.peaceOfMinde.dao;

import ecse428.peaceOfMinde.model.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin, Integer> {
    Optional<Admin> findAdminByEmail(String email);
    Optional<Admin> findAdminByUsername(String username);
 }

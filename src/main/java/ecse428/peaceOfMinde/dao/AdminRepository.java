package ecse428.peaceOfMinde.dao;

import ecse428.peaceOfMinde.model.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin, Integer> {
    Admin findAdminByEmail(String email);
    Admin findAdminById(Integer id);
}

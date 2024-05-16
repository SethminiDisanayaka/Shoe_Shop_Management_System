package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
    Boolean existsByEmployeeCode(String id);

    @Query(value = "SELECT employee_code FROM employee ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}

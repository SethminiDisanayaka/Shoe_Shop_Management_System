package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}

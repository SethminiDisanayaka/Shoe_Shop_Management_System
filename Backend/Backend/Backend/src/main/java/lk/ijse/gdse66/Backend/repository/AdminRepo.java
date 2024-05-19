package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.dto.AdminDTO;
import lk.ijse.gdse66.Backend.enttity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminEntity, String> {

}

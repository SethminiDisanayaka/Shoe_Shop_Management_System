package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.dto.AdminPanelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminPanelDTO, String> {

}

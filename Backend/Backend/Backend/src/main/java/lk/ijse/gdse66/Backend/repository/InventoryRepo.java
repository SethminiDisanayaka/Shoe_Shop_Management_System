package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity ,String> {
}

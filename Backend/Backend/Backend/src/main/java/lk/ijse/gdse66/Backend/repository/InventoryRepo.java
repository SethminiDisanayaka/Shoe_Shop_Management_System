package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepo extends JpaRepository<InventoryEntity, String> {
    Boolean existsByItemCode(String id);
    InventoryEntity findByItemCode(String id);
    void deleteByItemCode(String id);
    @Query(value = "SELECT COUNT(*) FROM Inventory", nativeQuery = true)
    Long countInventoryRows();
}

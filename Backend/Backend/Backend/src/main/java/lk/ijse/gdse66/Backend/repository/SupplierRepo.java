package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepo extends JpaRepository<SupplierEntity ,String> {
    Boolean existsBySupplierCode(String id);
    SupplierEntity findBySupplierCode(String id);
    void deleteBySupplierCode(String id);
    @Query(value = "SELECT supplier_code FROM Suppliers ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String findLatestSupplierCode();
}

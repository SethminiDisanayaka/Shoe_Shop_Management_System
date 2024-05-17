package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<SalesEntity,String> {
    Boolean existsByOrderNo(String id);
    SalesEntity findByOrderNo(String id);
    void deleteByOrderNo(String id);
}

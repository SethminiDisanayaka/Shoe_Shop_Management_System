package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.SalesDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDetailRepo extends JpaRepository<SalesDetailsEntity,String> {
    Boolean existsBySalesOrderNo(String id);
    List<SalesDetailsEntity> findAllBySalesOrderNo(String id);
    void deleteAllBySalesOrderNo(String id);
    Boolean existsAllBySalesOrderNo(String id);
}

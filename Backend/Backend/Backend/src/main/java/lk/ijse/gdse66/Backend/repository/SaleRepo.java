package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SaleRepo extends JpaRepository<SalesEntity,String> {
    Boolean existsByOrderNo(String id);
    SalesEntity findByOrderNo(String id);
    void deleteByOrderNo(String id);
    List<SalesEntity> findAllByPurchaseDate(Date date);
    @Query("SELECT o.purchaseDate FROM SalesEntity o")
    List<Date>findAllPurchaseDate();
    @Query(value = "SELECT order_no FROM Sales ORDER BY order_no DESC LIMIT 1", nativeQuery = true)
    String findLatestOrderCode();
    @Query(value = "SELECT * FROM sales s WHERE DATE(s.purchase_date) = :today", nativeQuery = true)
    List<SalesEntity> findTodaySales(@Param("today") String today);
}

 package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> { // Assuming the primary key type is Long
    CustomerEntity findByCustomerCode(String id);
    Boolean existsByCustomerCode(String id);
    void deleteByCustomerCode(String id);

    @Query(value = "SELECT customer_code FROM Customers ORDER BY customer_code DESC LIMIT 1", nativeQuery = true)
    String findLatestCustomerCode();
}

package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {


}

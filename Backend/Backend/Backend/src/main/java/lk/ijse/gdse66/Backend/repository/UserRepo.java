package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT uder_id FROM user ORDER BY uder_id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}

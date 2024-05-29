package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.UserEntity;
import lk.ijse.gdse66.Backend.enums.AccessRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,String> {
    Boolean existsByEmail(String email);
    UserEntity findByEmailAndRole(String email, AccessRole role);
    void deleteByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}

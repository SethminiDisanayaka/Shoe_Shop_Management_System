package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}

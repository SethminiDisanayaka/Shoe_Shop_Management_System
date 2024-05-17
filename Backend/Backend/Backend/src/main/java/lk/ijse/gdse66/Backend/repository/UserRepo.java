package lk.ijse.gdse66.Backend.repository;

import lk.ijse.gdse66.Backend.enttity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity,String> {
    @Query(value = "select * from user where username=? AND password=? limit 1",nativeQuery = true)
    UserEntity findUserByUser_NameAndPassword(String username, String password) throws RuntimeException;
}

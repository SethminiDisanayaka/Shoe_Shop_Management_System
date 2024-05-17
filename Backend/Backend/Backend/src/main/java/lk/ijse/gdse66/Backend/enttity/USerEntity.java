package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.*;
import lk.ijse.gdse66.Backend.enums.AccessRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String userId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccessRole role;

}

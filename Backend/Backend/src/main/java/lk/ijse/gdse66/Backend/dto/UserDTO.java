package lk.ijse.gdse66.Backend.dto;

import lk.ijse.gdse66.Backend.enums.AccessRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String email;
    private String password;
    private AccessRole role;
}

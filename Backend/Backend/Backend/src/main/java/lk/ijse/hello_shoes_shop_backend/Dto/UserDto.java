package lk.ijse.hello_shoes_shop_backend.Dto;

import lk.ijse.hello_shoes_shop_backend.enums.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto implements SuperDto{
    private String email;
    private String name;
    private String password;
    private Role role;
    private String emp_Id;
//    private EmployeeEntity employeeEntity;
}

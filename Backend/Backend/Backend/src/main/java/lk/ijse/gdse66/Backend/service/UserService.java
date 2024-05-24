package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import lk.ijse.gdse66.Backend.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    UserDetailsService userDetailService();
    UserDTO saveUser(UserDTO dto);
    UserDTO updateUser(UserDTO dto);
    boolean deleteUser(String id);
    List<UserDTO> getAllUsers();

    @ResponseBody
    CustomDTO userIdGenerate();

    UserDTO getRegUsers(String username,String password);
}

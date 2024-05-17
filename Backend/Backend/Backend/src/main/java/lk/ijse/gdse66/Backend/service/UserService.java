package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String id);
    ArrayList<UserDTO> getAllUser();
    List<UserDTO> searchOrder(String id);
}

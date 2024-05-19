package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.AdminDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;

import java.util.List;

public interface AdminService {
    AdminDTO saveAdmin(AdminDTO dto);
    AdminDTO updateAdmin(AdminDTO dto);
    boolean deleteAdmin(String id);
    List<AdminDTO> getAllAdmin();

}

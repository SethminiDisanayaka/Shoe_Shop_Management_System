package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO dto);
    EmployeeDTO updateEmployee(EmployeeDTO dto);
    boolean deleteEmployee(String id);
    List<EmployeeDTO> getAllEmployee();

    @ResponseBody
    CustomDTO employeeIdGenerate();
}

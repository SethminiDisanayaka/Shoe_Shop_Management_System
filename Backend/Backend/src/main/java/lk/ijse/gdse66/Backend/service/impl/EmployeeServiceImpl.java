package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.enttity.EmployeeEntity;
import lk.ijse.gdse66.Backend.repository.EmployeeRepo;
import lk.ijse.gdse66.Backend.service.EmployeeService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new DuplicateRecordException("Customer ID is Already Exist");
        }
        return modelMapper.map(employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class)),EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO dto) {
        return null;
    }

    @Override
    public void deleteEmployee(String employeeCode) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }
}

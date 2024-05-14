package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.enttity.EmployeeEntity;
import lk.ijse.gdse66.Backend.repository.EmployeeRepo;
import lk.ijse.gdse66.Backend.service.EmployeeService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new DuplicateRecordException("Customer ID is Already Exist");
        }
        return mapper.map(employeeRepo.save(mapper.map(employeeDTO, EmployeeEntity.class)),EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (!employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new NotFoundException("Can't find customer id!!!");
        }
        return mapper.map(employeeRepo.save(mapper.map(employeeDTO ,EmployeeEntity.class)) ,EmployeeDTO.class);
    }

    @Override
    public boolean deleteEmployee(String id) {
        if (!employeeRepo.existsById(id)){
            throw new NotFoundException("Can't find customer id!!!");
        }
        employeeRepo.deleteById(id);
        return false;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class)).toList();

    }
}

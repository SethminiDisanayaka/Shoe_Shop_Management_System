package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.repository.CustomerRepo;
import lk.ijse.gdse66.Backend.service.CustomerService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerCode())){
            throw new DuplicateRecordException("Customer ID is Already Exist");
        }
        return mapper.map(customerRepo.save(mapper.map(customerDTO, CustomerEntity.class)),CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCustomerCode())){
            throw new NotFoundException("Can't find customer id!!!");
        }
        return mapper.map(customerRepo.save(mapper.map(customerDTO ,CustomerEntity.class)) ,CustomerDTO.class);
    }

    @Override
    public boolean deleteCustomer(String customerCode) {
        if (!customerRepo.existsById(customerCode)){
            throw new NotFoundException("Can't find customer id!!!");
        }
        customerRepo.existsById(customerCode);
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
       return customerRepo.findAll().stream().map(customerEntity -> mapper.map(customerEntity,CustomerDTO.class)).toList();
    }
}

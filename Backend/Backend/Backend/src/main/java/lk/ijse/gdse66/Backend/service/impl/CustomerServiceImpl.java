package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.enttity.CustomerEntity;
import lk.ijse.gdse66.Backend.repository.CustomerRepository;
import lk.ijse.gdse66.Backend.service.CustomerService;
import lk.ijse.gdse66.Backend.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(
                customer -> modelMapper.map(customer,CustomerDTO.class)
        ).toList();
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        if(!customerRepository.existsByCustomerCode(id)){
            throw new NotFoundException("Customer "+id+" Not Found!");
        }
        return modelMapper.map(customerRepository.findByCustomerCode(id), CustomerDTO.class);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsByCustomerCode(customerDTO.getCustomerCode())){
            throw new DuplicateRecordException("This Customer "+customerDTO.getCustomerCode()+" already exicts...");
        }
        customerDTO.setCustomerCode(genarateNextCustomerCode());
        return modelMapper.map(customerRepository.save(modelMapper.map(
                customerDTO, CustomerEntity.class)), CustomerDTO.class
        );
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        if(!customerRepository.existsByCustomerCode(id)){
            throw new NotFoundException("Customer ID"+ id + "Not Found...");
        }
        customerDTO.setCustomerCode(id);
        customerRepository.save(modelMapper.map(customerDTO,CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(String id) {
        if(!customerRepository.existsByCustomerCode(id)){
            throw  new NotFoundException("Customer ID"+ id + "Not Found...");
        }
        customerRepository.deleteByCustomerCode(id);
    }

    @Override
    public String genarateNextCustomerCode() {
        String lastCustomerCode = customerRepository.findLatestCustomerCode();
        if(lastCustomerCode==null){lastCustomerCode = "CUS000";}
        int numericPart = Integer.parseInt(lastCustomerCode.substring(3));
        numericPart++;
        String nextSupplierCode = "CUS" + String.format("%03d", numericPart);
        return nextSupplierCode;
    }
}

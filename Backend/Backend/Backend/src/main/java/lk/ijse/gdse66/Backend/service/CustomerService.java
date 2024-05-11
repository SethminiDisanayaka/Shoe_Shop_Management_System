package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO dto);
    CustomerDTO updateCustomer(CustomerDTO dto);
    boolean deleteCustomer(String customerCode);
    List<CustomerDTO> getAllCustomers();
}

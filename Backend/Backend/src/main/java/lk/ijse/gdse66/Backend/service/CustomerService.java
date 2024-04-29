package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String customerCode);
    ArrayList<CustomerDTO> getAllCustomer();
}

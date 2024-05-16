package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO dto);
    CustomerDTO updateCustomer(CustomerDTO dto);
    boolean deleteCustomer(String id);
    List<CustomerDTO> getAllCustomers();

    @ResponseBody
    CustomDTO customerIdGenerate();
}

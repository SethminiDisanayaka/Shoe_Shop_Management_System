package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        System.out.println("customer working !");
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.saveCustomer(customerDTO);
    }

    @PostMapping("/update")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        customerService.deleteCustomer(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerIdGenerate")
    public @ResponseBody
    CustomDTO customerIdGenerate() {
        return customerService.customerIdGenerate();
    }
}

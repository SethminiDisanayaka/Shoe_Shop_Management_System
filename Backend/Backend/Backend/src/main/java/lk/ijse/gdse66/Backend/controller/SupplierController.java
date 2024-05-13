package lk.ijse.gdse66.Backend.controller;


import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import lk.ijse.gdse66.Backend.service.EmployeeService;
import lk.ijse.gdse66.Backend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@CrossOrigin(origins="*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        System.out.println("Supplier is working");
    }

    @GetMapping("/getAllSuppliers")
    public List<SupplierDTO> getAllSupplier() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/save")
    public SupplierDTO save(@RequestBody SupplierDTO supplierDTO) {
        System.out.println(supplierDTO);
        return supplierService.saveSupplier(supplierDTO);
    }

    @PostMapping("/update")
    public SupplierDTO update(@RequestBody SupplierDTO supplierDTO) {
        System.out.println(supplierDTO);
        return supplierService.updateSupplier(supplierDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")String id){
        supplierService.deleteSupplier(id);
    }

}

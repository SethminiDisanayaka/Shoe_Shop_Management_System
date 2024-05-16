package lk.ijse.gdse66.Backend.controller;


import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins="*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        System.out.println("Employee is working");
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllCustomers() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/save")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        return employeeService.saveEmployee(employeeDTO);
    }

    @PostMapping("/update")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        employeeService.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/EmployeeIdGenerate")
    public @ResponseBody
    CustomDTO customerIdGenerate() {
        return employeeService.employeeIdGenerate();
    }
}
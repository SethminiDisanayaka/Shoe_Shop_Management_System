package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.dto.AdminDTO;
import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.service.AdminService;
import lk.ijse.gdse66.Backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        System.out.println("Admin working");
    }


    @GetMapping("/getAllAdmin")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmin();
    }

    @PostMapping("/save")
    public AdminDTO save(@RequestBody AdminDTO adminDTO) {
        System.out.println(adminDTO);
        return adminService.saveAdmin(adminDTO);
    }

    @PostMapping("/update")
    public AdminDTO update(@RequestBody AdminDTO adminDTO){
        System.out.println(adminDTO);
        return adminService.updateAdmin(adminDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        adminService.deleteAdmin(id);
    }

}
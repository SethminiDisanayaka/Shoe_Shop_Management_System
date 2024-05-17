package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.UserDTO;
import lk.ijse.gdse66.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        System.out.println("user working !");
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.saveUser(userDTO);
    }

    @PostMapping("/update")
    public UserDTO update(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/UserIdGenerate")
    public @ResponseBody
    CustomDTO userIdGenerate() {
        return userService.userIdGenerate();
    }
}

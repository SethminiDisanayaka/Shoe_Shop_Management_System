package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.util.CurrentUser;
import lk.ijse.gdse66.Backend.util.ResponseUtil;
import lk.ijse.gdse66.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/loginForm")
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping(params = {"username"})
    public ResponseUtil setUser(String username,String password){
        CurrentUser.currentUser=service.getRegUsers(username,password);
        return new ResponseUtil("OK","Successfully Loaded..!","");
    }

    @GetMapping(path = "current")
    public ResponseUtil getCurrentUser(){
        return new ResponseUtil("OK","Successfully Loaded..!",CurrentUser.currentUser);
    }

}

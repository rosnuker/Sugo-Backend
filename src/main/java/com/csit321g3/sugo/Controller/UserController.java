package com.csit321g3.sugo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.sugo.Entity.UserEntity;
import com.csit321g3.sugo.Service.UserService;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    UserService userv;

    @PostMapping("/registerUser")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        return userv.registerUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userv.getAllUsers();
    }

    @PutMapping("/updateCustomer")
    public UserEntity updateUser(@RequestParam Long uid, @RequestBody UserEntity newUserDetails) {
        return userv.updateUser(uid, newUserDetails);
    }

    @DeleteMapping("/deleteUser/{uid}")
    public String deleteUser(@PathVariable Long uid) {
        return userv.deleteUser(uid);
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestBody UserEntity user) {
        return userv.loginUser(user);
    }

    @GetMapping("/countUser")
    public long countUser() {
        return userv.countUser();
    }
    
}

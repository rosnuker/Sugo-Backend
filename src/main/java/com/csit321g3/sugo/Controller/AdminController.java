package com.csit321g3.sugo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.sugo.Entity.AdminEntity;
import com.csit321g3.sugo.Service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    AdminService aserv;

    @PostMapping("registerAdmin")
    public AdminEntity registerAdmin(@RequestBody AdminEntity admin) {
        return aserv.registerAdmin(admin);
    }

    @GetMapping("/getAllAdmins")
    public List<AdminEntity> getAllAdmin() {
        return aserv.getAllAdmins();
    }
    
    @PutMapping("updateAdmin")
    public AdminEntity updateAdmin(@RequestParam Long aid, @RequestBody AdminEntity newAdminDetails) {
        return aserv.updateAdmin(aid, newAdminDetails);
    }
    
    @DeleteMapping("/deleteAdmin/{aid}")
    public String deleteAdmin(@PathVariable Long aid) {
        return aserv.deleteAdmin(aid);
    }

    @PostMapping("/loginAdmin")
    public AdminEntity loginAdmin(@RequestBody AdminEntity admin) {
        return aserv.loginAdmin(admin);
    }

    @GetMapping("countAdmin")
    public Long countAdmin() {
        return aserv.countAdmin();
    }
    
    @GetMapping("/adminExists")
    public String adminExists(@RequestParam String email) {
        return aserv.adminExists(email);
    }
    
}

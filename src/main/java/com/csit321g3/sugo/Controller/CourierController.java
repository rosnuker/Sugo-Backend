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

import com.csit321g3.sugo.Entity.CourierEntity;
import com.csit321g3.sugo.Service.CourierService;

@RestController
@CrossOrigin("http://localhost:5173")
public class CourierController {

    @Autowired
    CourierService cserv;

    @PostMapping("/registerCourier")
    public CourierEntity registerCourier(@RequestBody CourierEntity courier) {
        return cserv.registerCourier(courier);
    }

    @GetMapping("/getAllCouriers")
    public List<CourierEntity> getAllUsers() { 
        return cserv.getAllCouriers();
    }

    @PutMapping("/updateCourier")
    public CourierEntity updateCourier(@RequestParam Long cid, @RequestBody CourierEntity newCourierDetails) {
        return cserv.updateCourier(cid, newCourierDetails);
    }

    @DeleteMapping("/deleteCourier/{cid}")
    public String deleteCourier(@PathVariable Long cid) {
        return cserv.deleteCourier(cid);
    }

    @PostMapping("/loginCourier")
    public String loginCourier(@RequestBody CourierEntity courier) {
        return cserv.loginCourier(courier);
    }
}

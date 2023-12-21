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

import com.csit321g3.sugo.Entity.OrderEntity;
import com.csit321g3.sugo.Service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    @Autowired
    OrderService oserv;

    @PostMapping("/addOrder")
    public OrderEntity addOrder(@RequestParam Long uid, @RequestBody OrderEntity order) {
        return oserv.addOrder(uid, order);
    }

    @GetMapping("/getAllOrders")
    public List<OrderEntity> getAllOrders() {
        return oserv.getAllOrders();
    }

    @PutMapping("/addCourierToOrder")
    public OrderEntity addCourierToOrder(@RequestParam Long oid, @RequestParam Long cid) {
        return oserv.addCourierToOrder(oid, cid);
    }

    @PutMapping("/updateOrderStatus")
    public OrderEntity updateOrderStatus(@RequestParam Long oid, @RequestBody String status) {
        return oserv.updateOrderStatus(oid, status);
    }

    @DeleteMapping("/deleteOrder/{oid}")
    public String deleteUser(@PathVariable Long oid) {
        return oserv.deleteOrder(oid);
    }

    @GetMapping("/countOrder")
    public Long countOrder() {
        return oserv.countOrder();
    }

}

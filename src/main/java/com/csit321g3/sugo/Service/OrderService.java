package com.csit321g3.sugo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.sugo.Entity.CourierEntity;
import com.csit321g3.sugo.Entity.OrderEntity;
import com.csit321g3.sugo.Entity.UserEntity;
import com.csit321g3.sugo.Repository.CourierRepository;
import com.csit321g3.sugo.Repository.OrderRepository;
import com.csit321g3.sugo.Repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orepo;

    @Autowired
    UserRepository urepo;

    @Autowired
    CourierRepository crepo;

    public OrderEntity addOrder(Long uid, OrderEntity order) {
        UserEntity user = new UserEntity();

        if(urepo.findById(uid) != null) {
            user = urepo.findById(uid).get();
            order.setUser(user);
        }

        return orepo.save(order);
    }

    public List<OrderEntity> getAllOrders() {
        return orepo.findAll();
    }

    @SuppressWarnings("finally")
    public OrderEntity addCourierToOrder(Long oid, Long cid) {
        OrderEntity order = new OrderEntity();
        CourierEntity courier = new CourierEntity();

        try {
            order = orepo.findById(oid).get();

            if(crepo.findById(cid) != null) {
                courier = crepo.findById(cid).get();
                order.setCourier(courier);
            }
            
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("Order " + oid + " does not exist.");
        } finally {
            return orepo.save(order);
        }
    }

    @SuppressWarnings("finally")
    public OrderEntity updateOrderStatus(Long oid, String status) {
        OrderEntity order = new OrderEntity();

        try {
            order = orepo.findById(oid).get();
            order.setStatus(status);
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("Order " + oid + " does not exist.");
        } finally {
            return orepo.save(order);
        }
    }

    public String deleteOrder(Long oid) {
        String msg = "";

        OrderEntity order = new OrderEntity();

        if(orepo.findById(oid) != null) {
            order = orepo.findById(oid).get();
            order.setDeleted(true);

            orepo.save(order);
            msg = "Order " + oid + " is successfully deleted.";
        } else {
            msg = "Order " + oid + " does not exist.";
        }
        return msg;
    }
}

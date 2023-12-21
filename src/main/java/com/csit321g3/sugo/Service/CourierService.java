package com.csit321g3.sugo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csit321g3.sugo.Entity.CourierEntity;
import com.csit321g3.sugo.Repository.CourierRepository;

@Service
public class CourierService {
    
    @Autowired
    CourierRepository crepo;

    public CourierEntity registerCourier(CourierEntity courier) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(courier.getPassword());
        courier.setPassword(encryptedPwd);

        return crepo.save(courier);
    }

    public List<CourierEntity> getAllCouriers() {
        return crepo.findAll();
    }

    @SuppressWarnings("finally")
    public CourierEntity updateCourier(Long cid, CourierEntity newCourierDetails) {
        CourierEntity courier = new CourierEntity();

        try {
            courier = crepo.findById(cid).get();
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("Courier " + cid + " does not exist.");
        } finally {
            return crepo.save(courier);
        }
    }

    public String deleteCourier(Long cid) {
        String msg = "";
        CourierEntity courier = new CourierEntity();

        if(crepo.findById(cid) != null) {
            courier = crepo.findById(cid).get();
            courier.setDeleted(true);

            crepo.save(courier);
            msg =  "Courier " + cid + " is successfully deleted.";
        } else {
            msg = "Courier " + cid + " does not exist.";
        }

        return msg;
    }

    public CourierEntity loginCourier(CourierEntity courier) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        CourierEntity opCourier = crepo.findByEmail(courier.getEmail());
        int matches = 0;

        if(opCourier != null) {
            if(bcrypt.matches(courier.getPassword(), opCourier.getPassword())) {
                matches = 1;
            } 
        } 

        return opCourier;
    }

    public Long countCourier() {
        return crepo.count();
    }

    public String courierExists(String email) {
        if(crepo.findByEmail(email) != null) {
            return "Exists.";
        } else {
            return "Does not exists.";
        }
    }
}

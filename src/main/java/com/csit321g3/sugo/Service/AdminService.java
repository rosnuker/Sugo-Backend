package com.csit321g3.sugo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csit321g3.sugo.Entity.AdminEntity;
import com.csit321g3.sugo.Repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    AdminRepository arepo;

    public AdminEntity registerAdmin(AdminEntity admin) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(admin.getPassword());
        admin.setPassword(encryptedPwd);

        return arepo.save(admin);
    }

    public List<AdminEntity> getAllAdmins() {
        return arepo.findAll();
    }

    @SuppressWarnings("finally")
    public AdminEntity updateAdmin(Long aid, AdminEntity newAdminDetails) {
        AdminEntity admin = new AdminEntity();

        try {
            admin = arepo.findById(aid).get();
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("Admin " + aid + " does not exist.");
        } finally {
            return arepo.save(admin)
        }
    }

    public String deleteAdmin(Long aid) {
        String msg = "";
        AdminEntity admin = new AdminEntity();

        if(arepo.findById(aid) != null) {
            admin = arepo.findById(aid).get();
            admin.setDeleted(true);

            arepo.save(admin);
            msg = "Admin " + aid + " is successfully deleted.";
        } else {
            msg = "Admin " + aid + " does not exist.";
        }

        return msg;
    }

    public AdminEntity loginAdmin(AdminEntity admin) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        AdminEntity opAdmin = arepo.findByEmail(admin.getEmail());
        int matches = 0;

        if(opAdmin != null) {
            if(bcrypt.matches(admin.getPassword(), opAdmin.getPassword())) {
                matches = 1;
            }
        }

        return opAdmin;
    }

    public Long countAdmin() {
        return arepo.count();
    }

    public String adminExists(String email) {
        if(arepo.findByEmail(email) != null) {
            return "Exists.";
        } else {
            return "Does not exist.";
        }
    }
}

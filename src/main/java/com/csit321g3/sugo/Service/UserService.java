package com.csit321g3.sugo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csit321g3.sugo.Entity.UserEntity;
import com.csit321g3.sugo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository urepo;

    public UserEntity registerUser(UserEntity user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPwd);

        return urepo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return urepo.findAll();
    }

    @SuppressWarnings("finally")
    public UserEntity updateUser(Long uid, UserEntity newUserDetails) {
        UserEntity user = new UserEntity();

        try {
            user = urepo.findById(uid).get();
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("User " + uid + " does not exist.");
        } finally {
            return urepo.save(user);
        }
    }

    public String deleteUser(Long uid) {
        String msg = "";
        UserEntity user = new UserEntity();

        if(urepo.findById(uid) != null) {
            user = urepo.findById(uid).get();
            user.setDeleted(true);

            urepo.save(user);
            msg = "User " + uid + " is successfully deleted.";
        } else {
            msg = "User " + uid + " does not exist.";
        }

        return msg;
    }

    public String loginUser(UserEntity user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        UserEntity opUser = urepo.findByEmail(user.getEmail());

        if(opUser != null) {
            if(bcrypt.matches(user.getPassword(), opUser.getPassword())) {
                return "Login Success!";
            } else {
                return "Login Failed.";
            }
        } else {
            return "User does not exist.";
        }
    }

    public long countUser() {
        return urepo.count();
    }
}

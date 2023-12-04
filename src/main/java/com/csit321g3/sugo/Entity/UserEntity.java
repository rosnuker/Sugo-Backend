package com.csit321g3.sugo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbluser")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column(name = "firstname")
    private String fname;

    @Column(name="lastname")
    private String lname;
    
    private String email;
    private String password;
    private String role;
    private boolean isDeleted;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> order;

    public UserEntity() {
    }

    public UserEntity(String fname, String lname, String email, String password, String role, boolean isDeleted,
            List<OrderEntity> order) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDeleted = isDeleted;
        this.order = order;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<OrderEntity> getOrder() {
        return order;
    }

    public void setOrder(List<OrderEntity> order) {
        this.order = order;
    }
}

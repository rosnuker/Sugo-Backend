package com.csit321g3.sugo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblorder")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;

    private double amountToPay;
    private String method;
    private String message;
    private String location;
    private String status;
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "uid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "cid")
    private CourierEntity courier;
    
    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, CourierEntity courier, double amountToPay, String method, String message,
            String location, String status, boolean isDeleted) {
        this.user = user;
        this.courier = courier;
        this.amountToPay = amountToPay;
        this.method = method;
        this.message = message;
        this.location = location;
        this.status = status;
        this.isDeleted = isDeleted;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CourierEntity getCourier() {
        return courier;
    }

    public void setCourier(CourierEntity courier) {
        this.courier = courier;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}

package com.ty.jmrp_logistics.entity;

import io.swagger.v3.oas.models.info.License;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    @NotEmpty
    private String userName;
    @Size(min = 3, message = "must be greater than 3")
    private String userPassword;
    @Min(value = 55555555, message = "more than length 8")
    private long userPhoneNumber;
    @OneToOne
    private Address address;
    @NotEmpty
    private String userRole;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}

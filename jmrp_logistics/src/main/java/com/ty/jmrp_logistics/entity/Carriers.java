package com.ty.jmrp_logistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Carriers {
    @Id
    private int id;
    @NotEmpty
    private String carrierCompanyName;
    @Min(value = 55555555, message = "more than length 8")
    private long carrierContact;
    @Email
    private String carrierEmail;
    @OneToMany(mappedBy = "carriers")
    List<Driver> driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrierCompanyName() {
        return carrierCompanyName;
    }

    public void setCarrierCompanyName(String carrierCompanyName) {
        this.carrierCompanyName = carrierCompanyName;
    }

    public long getCarrierContact() {
        return carrierContact;
    }

    public void setCarrierContact(long carrierContact) {
        this.carrierContact = carrierContact;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
}

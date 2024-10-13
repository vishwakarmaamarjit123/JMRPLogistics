package com.ty.jmrp_logistics.entity;

import com.ty.jmrp_logistics.utility.DateProvider;
import com.ty.jmrp_logistics.utility.TimeProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Unloading {
    @Id
    private int id;
    @NotEmpty
    private String companyName;
    @OneToOne
    private Address address;
    private LocalDate unloadingDate;
    private LocalTime unloadingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(DateProvider unloadingDate) {
        this.unloadingDate = LocalDate.of(unloadingDate.getYear(), unloadingDate.getMonth(), unloadingDate.getDay());
    }

    public LocalTime getUnloadingTime() {
        return unloadingTime;
    }

    public void setUnloadingTime(TimeProvider unloadingTime) {
        this.unloadingTime =  LocalTime.of(unloadingTime.getHour(), unloadingTime.getMinute());
    }
}

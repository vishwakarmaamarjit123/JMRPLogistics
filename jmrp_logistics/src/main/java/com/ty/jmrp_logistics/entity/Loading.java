package com.ty.jmrp_logistics.entity;

import com.ty.jmrp_logistics.utility.DateProvider;
import com.ty.jmrp_logistics.utility.TimeProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Loading {
    @Id
    private int id;
    @NotNull
    private String companyName;
    @OneToOne
    private Address address;
    private LocalDate loadingDate;
    private LocalTime loadingTime;

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

    public LocalDate getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(DateProvider loadingDate) {
        this.loadingDate = LocalDate.of(loadingDate.getYear(), loadingDate.getMonth(), loadingDate.getDay());
    }

    public LocalTime getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(TimeProvider loadingTime) {
        this.loadingTime = LocalTime.of(loadingTime.getHour(), loadingTime.getMinute());
    }
}

package com.ty.jmrp_logistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    private  int id;
    @NotNull
    private String streetName;
    @NotNull
    private int houseNumber;
    private int areaPincode;
    @NotNull
    private String ditrict;
    @NotNull
    private String state;
    @NotNull
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAreaPincode() {
        return areaPincode;
    }

    public void setAreaPincode(int areaPincode) {
        this.areaPincode = areaPincode;
    }

    public String getDitrict() {
        return ditrict;
    }

    public void setDitrict(String ditrict) {
        this.ditrict = ditrict;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

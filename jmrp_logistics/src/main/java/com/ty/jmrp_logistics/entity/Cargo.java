package com.ty.jmrp_logistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Cargo {
    @Id
    private  int id;
    @NotEmpty
    private String cargoName;
    @NotEmpty
    private String cargoDescription;
    private double cargoWeight;
    @Min(value = 1, message = "count must be greater than or equals to 1")
    private int cargoCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCargoCount() {
        return cargoCount;
    }

    public void setCargoCount(int cargoCount) {
        this.cargoCount = cargoCount;
    }
}


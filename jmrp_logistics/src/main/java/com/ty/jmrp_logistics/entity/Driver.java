package com.ty.jmrp_logistics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Driver {
    @Id
    private int id;
    @NotEmpty
    private String driverName;
    @Min(value = 55555555, message = "more than length 8")
    private long driverPhoneNumber;
    @Size(min = 3, message = "req more than length 3")
    private String truckRegisteredNumber;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    Carriers carriers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(long driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getTruckRegisteredNumber() {
        return truckRegisteredNumber;
    }

    public void setTruckRegisteredNumber(String truckRegisteredNumber) {
        this.truckRegisteredNumber = truckRegisteredNumber;
    }

    public Carriers getCarriers() {
        return carriers;
    }

    public void setCarriers(Carriers carriers) {
        this.carriers = carriers;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", driverName='" + driverName + '\'' +
                ", driverPhoneNumber=" + driverPhoneNumber +
                ", truckRegisteredNumber='" + truckRegisteredNumber + '\'' +
                ", carriers=" + carriers +
                '}';
    }
}

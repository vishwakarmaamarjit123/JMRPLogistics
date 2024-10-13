package com.ty.jmrp_logistics.entity;

import com.ty.jmrp_logistics.utility.DateProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orderss")
public class Order {
    @Id
    private int id;
    private LocalDate dateOfOrder;
    @NotNull
    private String orderStatus;
    @Min(value = 1, message = "more than length 1")
    private double freightCost;
    @NotNull
    private String additionalinfo;
    @ManyToOne
    private Carriers carriers;
    @OneToOne
    private Cargo cargo;
    @OneToOne
    private Loading loading;
    @OneToOne
    private Unloading unloading;
    @ManyToMany
    private List<User> loadingUser;
    @ManyToMany
    private List<User> unloadingUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(DateProvider dateOfOrder) {
        this.dateOfOrder = LocalDate.of(dateOfOrder.getYear(), dateOfOrder.getMonth(), dateOfOrder.getDay());
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(double freightCost) {
        this.freightCost = freightCost;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public Carriers getCarriers() {
        return carriers;
    }

    public void setCarriers(Carriers carriers) {
        this.carriers = carriers;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Loading getLoading() {
        return loading;
    }

    public void setLoading(Loading loading) {
        this.loading = loading;
    }

    public Unloading getUnloading() {
        return unloading;
    }

    public void setUnloading(Unloading unloading){
        this.unloading = unloading;
    }


    public List<User> getLoadingUser() {
        return loadingUser;
    }

    public void setLoadingUser(List<User> loadingUser) {
        this.loadingUser = loadingUser;
    }

    public List<User> getUnloadingUser() {
        return unloadingUser;
    }

    public void setUnloadingUser(List<User> unloadingUser) {
        this.unloadingUser = unloadingUser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOfOrder=" + dateOfOrder +
                ", orderStatus='" + orderStatus + '\'' +
                ", freightCost=" + freightCost +
                ", additionalinfo='" + additionalinfo + '\'' +
                ", carriers=" + carriers +
                ", cargo=" + cargo +
                ", loading=" + loading +
                ", unloading=" + unloading +
                ", loadingUser=" + loadingUser +
                ", unloadingUser=" + unloadingUser +
                '}';
    }
}

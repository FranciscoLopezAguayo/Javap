package com.javap.fjla.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RegisteredSale implements Serializable {

    private RegisteredUser salesPerson;
    private RegisteredUser customer;
    private Date saleDate;
    private BigDecimal saleAmount;
    private String processTracking ;
    private List<RegisteredSale_Item> items;

    public RegisteredUser getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(RegisteredUser salesPerson) {
        this.salesPerson = salesPerson;
    }

    public RegisteredUser getCustomer() {
        return customer;
    }

    public void setCustomer(RegisteredUser customer) {
        this.customer = customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getProcessTracking() {
        return processTracking;
    }

    public void setProcessTracking(String processTracking) {
        this.processTracking = processTracking;
    }

    public List<RegisteredSale_Item> getItems() {
        return items;
    }

    public void setItems(List<RegisteredSale_Item> items) {
        this.items = items;
    }
}

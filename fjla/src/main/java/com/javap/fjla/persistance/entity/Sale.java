package com.javap.fjla.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "salesPerson_user_id")
    private User salesPerson;

    @ManyToOne
    @JoinColumn(name = "Customer_user_id")
    private User customer;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_Date", nullable = false)
    private Date saleDate;

    private BigDecimal saleAmount;

    public static enum processTracking{
        IN_PROGRESS,
        APPROVAL_PENDING,
        PROCESSING_PAYMENT,
        PACKING,
        SHIPPED,
        DELIVERED,
        CANCELED,
        RETRYING_PAYMENT,
        INVENTORY_ISSUE;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
    private List<Sale_Item> Items;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(User salesPerson) {
        this.salesPerson = salesPerson;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
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

    public List<Sale_Item> getItems() {
        return Items;
    }

    public void setItems(List<Sale_Item> items) {
        Items = items;
    }
}

package com.javap.fjla.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Sale_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "sales_id")
    //private Sales saleID; //ID de Venta

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int Qty;

    private BigDecimal productSaleAmount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "FK_Sale", nullable = false, updatable = false)
    private Sale sale;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public BigDecimal getProductSaleAmount() {
        return productSaleAmount;
    }

    public void setProductSaleAmount(BigDecimal productSaleAmount) {
        this.productSaleAmount = productSaleAmount;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}

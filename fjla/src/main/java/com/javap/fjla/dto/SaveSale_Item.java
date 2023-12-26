package com.javap.fjla.dto;

import com.javap.fjla.persistance.entity.Product;

import java.io.Serializable;

public class SaveSale_Item implements Serializable {

    private Long productId;

    private int Qty;

    //private double productSaleAmount;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "SaveSale_Item{" +
                "productId=" + productId +
                ", Qty=" + Qty +
                '}';
    }
}

package com.javap.fjla.dto;

import com.javap.fjla.persistance.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public class RegisteredSale_Item  implements Serializable {

    private RegisteredProduct product;
    private int Qty;
    private BigDecimal productSaleAmount;

    public RegisteredProduct getProduct() {
        return product;
    }

    public void setProduct(RegisteredProduct product) {
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
}

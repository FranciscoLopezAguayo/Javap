package com.javap.fjla.dto;


import java.io.Serializable;

import java.util.List;

public class SaveSale implements Serializable {

    //@NotBlank
    //private Long salesPerson;
    //@NotBlank
    private String Customer;

    //private Date saleDate;

    //private double saleAmount;

    //@Min(value = 1)
    //private Long processTracking;

    /*@Size.List({
            @Size(min = 1, groups = Sale_Item.class)
    })*/
    private List<SaveSale_Item> Items;


    /*
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @DecimalMin(value = "0")
    private int CurrentStock;

    */

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public List<SaveSale_Item> getItems() {
        return Items;
    }

    public void setItems(List<SaveSale_Item> items) {
        Items = items;
    }

    @Override
    public String toString() {
        return "SaveSale{" +
                "Customer='" + Customer + '\'' +
                ", Items=" + Items +
                '}';
    }
}

package com.javap.fjla.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

public class SaveSalesTransaction implements Serializable {

    @NotBlank
    private String Customer2;

    public String getCustomer2() {
        return Customer2;
    }

    public void setCustomer2(String customer2) {
        Customer2 = customer2;
    }

    @Override
    public String toString() {
        return "SaveSalesTransaction{" +
                "Customer2='" + Customer2 + '\'' +
                '}';
    }

    //private List<SaveSale_Item> Items;



//    public List<SaveSale_Item> getItems() {
//        return Items;
//    }
//
//    public void setItems(List<SaveSale_Item> items) {
//        Items = items;
//    }


}

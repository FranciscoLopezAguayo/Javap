package com.javap.fjla.service;

import com.javap.fjla.dto.RegisteredSale;
import com.javap.fjla.dto.SaveSale;
import com.javap.fjla.persistance.entity.Product;
import com.javap.fjla.persistance.entity.Sale;
import com.javap.fjla.persistance.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    //Page<Sale> findAll(Pageable pageable);
    RegisteredSale createOne(SaveSale saveSale, User userVendedor);
    //Page<Sale> findAllBycustomer(String customer, Pageable pageable);

    //List<Sale> findAllSalesBycustomer(String customer);

    List<Sale> findUserSales(String username,Pageable pageable);

    //Page<Tutorial> findByPublished(boolean published, Pageable pageable);

    Page<Sale> findAll(Pageable pageable);

    Optional<Sale> findOneById(Long SaleId);



}

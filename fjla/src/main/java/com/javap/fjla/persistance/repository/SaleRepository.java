package com.javap.fjla.persistance.repository;

import com.javap.fjla.persistance.entity.Sale;
import com.javap.fjla.persistance.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {



    //Page<Sale> findBycustomer(User customer, Pageable pageable);

    //List<User> findByRolesIn(Collection<String> names, Pageable pageable);
    //List<Sale> findByCustomerIn(Collection<User> Customer,Pageable pageable);
    List<Sale> findByCustomer(User customer,Pageable pageable);


   // List<Sale> findBycustomerXXX(User customer);

}

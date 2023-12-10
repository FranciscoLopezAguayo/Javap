package com.javap.fjla.persistance.repository;

import com.javap.fjla.persistance.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

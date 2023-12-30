package com.javap.fjla.persistance.repository;

import com.javap.fjla.persistance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();
}


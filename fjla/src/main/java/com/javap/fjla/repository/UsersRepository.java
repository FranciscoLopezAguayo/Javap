package com.javap.fjla.repository;

import com.javap.fjla.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}

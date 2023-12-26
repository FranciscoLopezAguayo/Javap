package com.javap.fjla.service;

import com.javap.fjla.dto.SaveUser;
import com.javap.fjla.persistance.entity.User;

import java.util.Optional;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);

}

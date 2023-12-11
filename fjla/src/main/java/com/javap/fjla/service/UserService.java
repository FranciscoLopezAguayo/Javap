package com.javap.fjla.service;

import com.javap.fjla.dto.SaveUser;
import com.javap.fjla.persistance.entity.User;

public interface UserService {
    User registrOneCustomer(SaveUser newUser);
}

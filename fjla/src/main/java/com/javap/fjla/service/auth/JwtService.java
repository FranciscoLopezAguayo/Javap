package com.javap.fjla.service.auth;

import com.javap.fjla.persistance.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(UserDetails user) {
        return null;
    }
}

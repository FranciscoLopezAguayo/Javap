package com.javap.fjla.config.security.filter;

import com.javap.fjla.exception.*;
import com.javap.fjla.service.UserService;
import com.javap.fjla.service.auth.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.Security;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Entro en el filtro JWT Authentication filter");

        String authorizationHeader = request.getHeader("Authorization"); //Bearer jwt
        if (!StringUtils.hasText(authorizationHeader)  || !authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        //aqui se obtiene ej JWT desde el tocken, y es la posicion 1 porque la 0 solo dice Bearer
        String jwt = authorizationHeader.split(" ")[1];

        String username = jwtService.extractUsername(jwt);

        UserDetails userDetails = userService.findOneByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("User not found. Username:"+ username));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username,null, userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);


        filterChain.doFilter(request,response);
    }
}

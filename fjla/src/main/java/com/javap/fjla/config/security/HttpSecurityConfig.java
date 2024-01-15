package com.javap.fjla.config.security;

import com.javap.fjla.config.security.filter.JwtAuthenticationFilter;
import com.javap.fjla.persistance.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class HttpSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        SecurityFilterChain filterChain = http
                .csrf( csrfConfig -> csrfConfig.disable() )
                .cors(Customizer.withDefaults())//enable cors
                .sessionManagement( sessMagConfig -> sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
                .authenticationProvider(daoAuthProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeHttpRequests( authReqConfig -> {
//                    //buildRequestMatchers(authReqConfig);
//                    buildRequestMatchersv2(authReqConfig);
//                } )
                .build();

        return filterChain;
    }

    private static void buildRequestMatchers(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
    /*

        autorización basado en coincidencias de solicitudes HTTP y permisos
    * Autorizacion de enpoint de productos
    * */
       /* authReqConfig.requestMatchers(HttpMethod.GET,"/products")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name()); */

        authReqConfig.requestMatchers(RegexRequestMatcher.regexMatcher(HttpMethod.GET, "/products/[0-9]*"))
        //authReqConfig.requestMatchers(HttpMethod.GET,"/products/{productId}")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.POST,"/products")
                .hasRole(Role.ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.PUT,"/products")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.PUT,"/products/{productId}/disabled")
                .hasRole(Role.ADMINISTRATOR.name());




                    /*
                        autorización basado en coincidencias de solicitudes HTTP y permisos
                     * Autorizacion de enpoint de categories
                     * */
        authReqConfig.requestMatchers(HttpMethod.GET,"/categories")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.GET,"/categories/{categoryId}")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.POST,"/categories")
                .hasRole(Role.ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.PUT,"/categories")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name());

        authReqConfig.requestMatchers(HttpMethod.PUT,"/categories/{categoryId}/disabled")
                .hasRole(Role.ADMINISTRATOR.name());



        authReqConfig.requestMatchers(HttpMethod.POST,"/Sales")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name(),Role.SALES_PERSON.name());

        authReqConfig.requestMatchers(HttpMethod.POST,"/TEST")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name(),Role.SALES_PERSON.name());


        authReqConfig.requestMatchers(HttpMethod.GET,"/auth/profile")
                .hasAnyRole(Role.ADMINISTRATOR.name(),Role.ASSISTANT_ADMINISTRATOR.name(),Role.CUSTOMER.name(),Role.SALES_PERSON.name());




        /* Autorizacion de endpoints publicos*/
        authReqConfig.requestMatchers(HttpMethod.POST, "/customers").permitAll();
        //authReqConfig.requestMatchers(HttpMethod.POST, "/sale").permitAll();
        //authReqConfig.requestMatchers(HttpMethod.POST, "/Test").permitAll();
        authReqConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();

        authReqConfig.anyRequest().authenticated();
    }

    private static void buildRequestMatchersv2(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {

        /* Autorizacion de endpoints publicos*/

        authReqConfig.requestMatchers(HttpMethod.POST, "/customers").permitAll();
        //authReqConfig.requestMatchers(HttpMethod.POST, "/sale").permitAll();
        //authReqConfig.requestMatchers(HttpMethod.POST, "/Test").permitAll();
        authReqConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();

        authReqConfig.anyRequest().authenticated();
    }

}

package com.javap.fjla.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");// Enable CORS for the whole application.
                //registry.addMapping("127.0.0.1/**");// Enable CORS for the whole application.


                //http://localhost:4000"
                //http://127.0.0.1:4000"

                //http://localhost:3000"
                //http://127.0.0.1:3000"

            }
        };
    }
}

package com.mani.securebank;

import com.mani.securebank.config.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
@EnableMethodSecurity
public class SecurebankApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurebankApplication.class, args);
    }

}

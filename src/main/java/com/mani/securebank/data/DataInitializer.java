package com.mani.securebank.data;


import com.mani.securebank.entity.AppUser;
import com.mani.securebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            if (userRepository.findByUsername("mani").isEmpty()) {
                userRepository.save(
                        AppUser.builder()
                                .username("mani")
                                .password(passwordEncoder.encode("mani123"))
                                .role("USER")
                                .build()
                );

            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(
                        AppUser.builder()
                                .username("admin")
                                .password(
                                        passwordEncoder.encode("admin123"))
                                .role("ADMIN")
                                .build()
                );

            }
        };
    }
}

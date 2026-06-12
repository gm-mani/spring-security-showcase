package com.mani.securebank.data;

import com.mani.securebank.entity.Account;
import com.mani.securebank.entity.AppUser;
import com.mani.securebank.model.Role;
import com.mani.securebank.repository.AccountRepository;
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
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initData() {

        return args -> {

            if (!userRepository.existsByUsername("mani")) {
                AppUser mani = userRepository.save(
                        AppUser.builder()
                                .username("mani")
                                .password(
                                        passwordEncoder.encode("password"))
                                .role(Role.USER)
                                .build()
                );

                accountRepository.save(
                        Account.builder()
                                .accountType("SAVINGS")
                                .balance(10000.0)
                                .owner(mani)
                                .build()
                );
            }
            if (!userRepository.existsByUsername("admin")) {
                AppUser admin = userRepository.save(
                        AppUser.builder()
                                .username("admin")
                                .password(
                                        passwordEncoder.encode("admin123"))
                                .role(Role.ADMIN)
                                .build()
                );

                accountRepository.save(
                        Account.builder()
                                .accountType("CURRENT")
                                .balance(25000.0)
                                .owner(admin)
                                .build()
                );
            }


        };
    }
}
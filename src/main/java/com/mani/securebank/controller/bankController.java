package com.mani.securebank.controller;


import com.mani.securebank.entity.Account;
import com.mani.securebank.repository.AccountRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class bankController {

    private final AccountRepository accountRepository;

    public bankController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/public")
    public String publicApi() {
        return "public";
    }

    @GetMapping("/admin")
    public String adminApi() {
        return "admin";
    }

    @GetMapping("/user")
    public String userApi() {
        return "user";
    }

    @GetMapping("/accounts/{id}")
    @PreAuthorize(
            "@accountSecurity.canAccessAccount(#id)"
    )
    public Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @GetMapping("/accounts")
    @PreAuthorize("hasAuthority('ACCOUNT_READ')")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @DeleteMapping("/accounts/delete/{id}")
    @PreAuthorize("hasAuthority('ACCOUNT_DELETE')")
    public String deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
        return "Account deleted";
    }


}

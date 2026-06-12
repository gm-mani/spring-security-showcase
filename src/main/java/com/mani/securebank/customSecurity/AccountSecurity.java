package com.mani.securebank.customSecurity;

import com.mani.securebank.entity.Account;
import com.mani.securebank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountSecurity {

    private final AccountRepository accountRepository;

    public boolean canAccessAccount(Long accId) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Account account = accountRepository.findById(accId)
                .orElseThrow();

        return account.getOwner()
                .getUsername()
                .equals(username);

    }

}

package com.mani.securebank.service;

import com.mani.securebank.entity.AppUser;
import com.mani.securebank.model.Role;
import com.mani.securebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(getAuthorities(user.getRole()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {

        List<GrantedAuthority> authorities =
                role.getPermissions()
                        .stream()
                        .map(permission ->
                                new SimpleGrantedAuthority(
                                        permission.name()
                                ))
                        .collect(Collectors.toList());

        authorities.add(
                new SimpleGrantedAuthority(
                        "ROLE_" + role.name()
                )
        );

        return authorities;
    }
}

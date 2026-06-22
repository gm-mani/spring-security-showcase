package com.mani.securebank.service;

import com.mani.securebank.entity.AppUser;
import com.mani.securebank.entity.RefreshToken;
import com.mani.securebank.exceptions.InvalidRefreshTokenException;
import com.mani.securebank.exceptions.UsernameAlreadyExistsException;
import com.mani.securebank.model.LoginResponse;
import com.mani.securebank.model.RegisterRequest;
import com.mani.securebank.model.Role;
import com.mani.securebank.repository.RefreshTokenRepository;
import com.mani.securebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public LoginResponse login(String username) {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User not found after authentication"));

        String accessToken = jwtService.generateAccessToken(username);
        String refreshToken = jwtService.generateRefreshToken(username);

        refreshTokenRepository.deleteByUser(user);

        refreshTokenRepository.save(RefreshToken.builder()
                .token(refreshToken)
                .user(user)
                .build());

        return new LoginResponse(accessToken, refreshToken);
    }

    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        AppUser user = AppUser.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }

    @Transactional
    public LoginResponse refresh(String refreshToken) {

        RefreshToken storedToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> new InvalidRefreshTokenException("Invalid refresh token"));

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtService.extractUsername(refreshToken));

        if (!jwtService.isRefreshTokenValid(refreshToken, userDetails)) {
            refreshTokenRepository.deleteByUser(storedToken.getUser());
            throw new InvalidRefreshTokenException("Invalid refresh token");
        }

        String username = userDetails.getUsername();
        String newAccessToken = jwtService.generateAccessToken(username);
        String newRefreshToken = jwtService.generateRefreshToken(username);

        refreshTokenRepository.delete(storedToken);
        refreshTokenRepository.save(RefreshToken.builder()
                .token(newRefreshToken)
                .user(storedToken.getUser())
                .build());

        return new LoginResponse(newAccessToken, newRefreshToken);
    }

    @Transactional
    public void logout(String refreshToken) {
        refreshTokenRepository.deleteByToken(refreshToken);
    }
}

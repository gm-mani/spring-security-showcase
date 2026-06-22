package com.mani.securebank.controller;

import com.mani.securebank.config.JwtConfig;
import com.mani.securebank.model.LoginRequest;
import com.mani.securebank.model.LoginResponse;
import com.mani.securebank.model.RegisterRequest;
import com.mani.securebank.service.AuthService;
import com.mani.securebank.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthService authService;
    private final JwtConfig jwtConfig;

    @GetMapping("/me")
    public ResponseEntity<String> me(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userDetails.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request,
                                               HttpServletResponse response) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        LoginResponse loginResponse = authService.login(request.username());

        setRefreshTokenCookie(response, loginResponse.refreshToken());
        return ResponseEntity.ok(new LoginResponse(loginResponse.accessToken(), null));
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(
            @CookieValue(name = "refreshToken") String refreshToken,
            HttpServletResponse response) {

        LoginResponse loginResponse = authService.refresh(refreshToken);

        setRefreshTokenCookie(response, loginResponse.refreshToken());
        return ResponseEntity.ok(new LoginResponse(loginResponse.accessToken(), null));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            @CookieValue(value = "refreshToken", required = false) String refreshToken,
            HttpServletResponse response) {

        if (refreshToken != null) {
            authService.logout(refreshToken);
        }

        clearRefreshTokenCookie(response);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    private void setRefreshTokenCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("refreshToken", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge((int) (jwtConfig.getRefreshExpiration()));
        cookie.setPath("/auth");
        response.addCookie(cookie);
    }

    private void clearRefreshTokenCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(0);
        cookie.setPath("/auth");
        response.addCookie(cookie);
    }
}

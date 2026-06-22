package com.mani.securebank.model;

public record RefreshResponse(LoginResponse loginResponse, String refreshToken) {
}

package com.mani.securebank.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime localDateTime,
        HttpStatus httpStatus,
        String errorMessage,
        String path
) {
}

package com.gianmdp03.brand_website.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private int code;
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(int code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}

package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private int errorCode;
    private Map<String, String> errors; // Field for validation errors

    // Constructor including validation errors
    public ErrorResponse(LocalDateTime timestamp, String message, int errorCode, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorCode = errorCode;
        this.errors = errors;
    }

    // Constructor without validation errors (for other exceptions)
    public ErrorResponse(LocalDateTime timestamp, String message, int errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorCode = errorCode;
    }

    // Getters and setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

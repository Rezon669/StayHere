package com.stayhere.app.exceptions;


public class CustomException extends RuntimeException {
    private final String reason;

    public CustomException(String message) {
        super(message);
        this.reason = "No additional details provided.";
    }

    public CustomException(String message, String reason) {
        super(message);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

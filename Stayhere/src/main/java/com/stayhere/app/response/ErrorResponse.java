package com.stayhere.app.response;

public class ErrorResponse {
    private String message;
    private String reason;

    public ErrorResponse(String message, String reason) {
        this.message = message;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}


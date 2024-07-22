package com.pokedex.pokedex;

public class ErrorResponse {
    private String message;
    private String field;
    private Object rejectedValue;

    public ErrorResponse(String message, String field, Object rejectedValue) {
        this.message = message;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }
}

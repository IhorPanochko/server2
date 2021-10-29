package com.example.server2.exception;

import java.io.Serializable;

public class ExceptionInfo implements Serializable {

    private String message;

    private String details;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

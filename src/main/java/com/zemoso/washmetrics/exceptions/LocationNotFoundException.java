package com.zemoso.washmetrics.exceptions;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(String message) {
        super(message);
    }

    public LocationNotFoundException(Throwable cause) {
        super(cause);
    }

    protected LocationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
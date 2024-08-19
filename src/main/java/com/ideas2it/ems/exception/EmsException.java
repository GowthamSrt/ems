package com.ideas2it.ems.exception;

public class EmsException extends RuntimeException {
    public EmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmsException(String message) {
        super(message);
    }
}



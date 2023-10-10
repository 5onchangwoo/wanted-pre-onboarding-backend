package com.preonboarding.backend.common.exception;

public class CannotMoneyNegativeException extends RuntimeException{
    public CannotMoneyNegativeException() {
        super();
    }

    public CannotMoneyNegativeException(String message) {
        super(message);
    }

    public CannotMoneyNegativeException(String message, Throwable cause) {
        super(message, cause);
    }
}

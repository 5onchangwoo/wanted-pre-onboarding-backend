package com.preonboarding.backend.common.exception;

public class CannotMonetNegative extends RuntimeException{
    public CannotMonetNegative() {
        super();
    }

    public CannotMonetNegative(String message) {
        super(message);
    }

    public CannotMonetNegative(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.preonboarding.backend.common.exception;

public class NotDifferentBeforeState extends RuntimeException {
    public NotDifferentBeforeState() {
        super();
    }

    public NotDifferentBeforeState(String message) {
        super(message);
    }

    public NotDifferentBeforeState(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDifferentBeforeState(Throwable cause) {
        super(cause);
    }

    protected NotDifferentBeforeState(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

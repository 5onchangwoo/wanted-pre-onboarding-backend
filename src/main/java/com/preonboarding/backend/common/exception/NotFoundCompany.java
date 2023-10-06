package com.preonboarding.backend.common.exception;

public class NotFoundCompany extends RuntimeException {
    public NotFoundCompany() {
    }

    public NotFoundCompany(String message) {
        super(message);
    }

    public NotFoundCompany(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundCompany(Throwable cause) {
        super(cause);
    }

    public NotFoundCompany(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

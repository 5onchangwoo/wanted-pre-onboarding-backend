package com.preonboarding.backend.common.exception;

public class NotFoundCompanyException extends RuntimeException {
    public NotFoundCompanyException() {
    }

    public NotFoundCompanyException(String message) {
        super(message);
    }

    public NotFoundCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundCompanyException(Throwable cause) {
        super(cause);
    }

    public NotFoundCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

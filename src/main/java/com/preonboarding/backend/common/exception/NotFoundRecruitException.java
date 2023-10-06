package com.preonboarding.backend.common.exception;

public class NotFoundRecruitException extends RuntimeException {
    public NotFoundRecruitException() {
        super();
    }

    public NotFoundRecruitException(String message) {
        super(message);
    }

    public NotFoundRecruitException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundRecruitException(Throwable cause) {
        super(cause);
    }

    protected NotFoundRecruitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

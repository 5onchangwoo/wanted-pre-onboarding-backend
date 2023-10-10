package com.preonboarding.backend.common.exception;

public class NoMoreApplyRecruitException extends RuntimeException {
    public NoMoreApplyRecruitException() {
        super();
    }

    public NoMoreApplyRecruitException(String message) {
        super(message);
    }

    public NoMoreApplyRecruitException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreApplyRecruitException(Throwable cause) {
        super(cause);
    }

    protected NoMoreApplyRecruitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

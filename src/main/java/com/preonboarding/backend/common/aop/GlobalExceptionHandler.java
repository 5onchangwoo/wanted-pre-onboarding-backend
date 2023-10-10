package com.preonboarding.backend.common.aop;

import com.preonboarding.backend.common.dto.ResponseDTO;
import com.preonboarding.backend.common.enumclass.CommonCode;
import com.preonboarding.backend.common.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundCompanyException.class)
    protected ResponseEntity<ResponseDTO> notFoundRecruitExceptionHandler(NotFoundCompanyException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(CommonCode.NOT_FOUND_COMPANY_ERROR, null));
    }

    @ExceptionHandler(NotFoundRecruitException.class)
    protected ResponseEntity<ResponseDTO> notFoundRecruitExceptionHandler(NotFoundRecruitException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(CommonCode.NOT_FOUND_RECRUIT_ERROR, null));
    }

    @ExceptionHandler(NotFoundUserException.class)
    protected ResponseEntity<ResponseDTO> notFoundUserExceptionHandler(NotFoundUserException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(CommonCode.NOT_FOUND_USER_ERROR, null));
    }

    @ExceptionHandler(NotDifferentBeforeState.class)
    protected ResponseEntity<ResponseDTO> noDifferentBeforeStateExceptionHandler(NotDifferentBeforeState e) {
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ResponseDTO(CommonCode.NOT_DIFFERENT_BEFORE_ERROR, null));
    }

    @ExceptionHandler(CannotMoneyNegativeException.class)
    protected ResponseEntity<ResponseDTO> cannotMoneyNegativeExceptionHandler(CannotMoneyNegativeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(CommonCode.BAD_REQUEST_ERROR, null));
    }

    @ExceptionHandler(NoMoreApplyRecruitException.class)
    protected ResponseEntity<ResponseDTO> noMoreApplyRecruitExceptionHandler(NoMoreApplyRecruitException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDTO(CommonCode.NO_MORE_APPLY, null));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseDTO> exceptionHandler(CannotMoneyNegativeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(CommonCode.INTERNAL_SERVER_ERROR, null));
    }
}

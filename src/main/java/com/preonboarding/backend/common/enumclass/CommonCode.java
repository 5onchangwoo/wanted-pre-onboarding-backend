package com.preonboarding.backend.common.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonCode {
    SUCCESS("S001", "성공하였습니다.");


    private final String CODE;
    private final String MESSAGE;
}

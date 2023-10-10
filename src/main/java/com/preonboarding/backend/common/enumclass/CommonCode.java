package com.preonboarding.backend.common.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonCode {
    SUCCESS("S001", "성공하였습니다."),
    NOT_FOUND_COMPANY_ERROR("E001", "해당 회사를 찾을 수 없습니다."),
    NOT_FOUND_RECRUIT_ERROR("E002", "해당 채용 공고를 찾을 수 없습니다."),
    NOT_FOUND_USER_ERROR("E003", "해당 유저를 찾을 수 없습니다."),
    NOT_DIFFERENT_BEFORE_ERROR("E004", "수정할 것이 없습니다."),
    NO_MORE_APPLY("E005", "한 공고에는 한번만 지원할 수 있습니다."),
    BAD_REQUEST_ERROR("E006", "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR("E999", "알수없는 서버 오류입니다.");

    private final String CODE;
    private final String MESSAGE;
    }

package com.preonboarding.backend.common.dto;

import com.preonboarding.backend.common.enumclass.CommonCode;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {
    private String code;
    private String message;
    private Object data;

    public ResponseDTO(CommonCode commonCode, Object data) {
        this.code = commonCode.getCODE();
        this.message = commonCode.getMESSAGE();
        this.data = data;
    }
}

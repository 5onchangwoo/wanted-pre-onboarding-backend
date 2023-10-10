package com.preonboarding.backend.recruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Deprecated
public class ApplyRecruitRequestDTO {
    private long recruitId;
    private long userId;

}

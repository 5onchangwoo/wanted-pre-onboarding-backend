package com.preonboarding.backend.recruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class GetRecruitDetailResponseDTO {
    private long recruitId;
    private String CompanyName;
    private String nation;
    private String region;
    private String position;
    private int bounty;
    private String skill;
    private String details;
    private List<Long> anotherRecruitListWithinCompany;
}

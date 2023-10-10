package com.preonboarding.backend.recruit.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class GetRecruitListResponseDTO {
    private long id;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private int bounty;
    private String skill;
}

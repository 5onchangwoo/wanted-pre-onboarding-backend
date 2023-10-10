package com.preonboarding.backend.company.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterRecruitRequestDTO {
    private long companyId;
    private String position;
    private int bounty;
    private String details;
    private String skill;
}

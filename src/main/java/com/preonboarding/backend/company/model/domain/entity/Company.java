package com.preonboarding.backend.company.model.domain.entity;


import com.preonboarding.backend.common.exception.NotFoundRecruitException;
import com.preonboarding.backend.company.model.domain.vo.CompanyId;
import com.preonboarding.backend.company.model.domain.vo.Money;
import com.preonboarding.backend.company.model.domain.vo.RecruitId;
import com.preonboarding.backend.company.model.domain.vo.WorkLocation;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "tbl_company")
public class Company {

    @EmbeddedId
    private CompanyId companyId;

    @Column(name = "company_name", length = 50, nullable = false)
    private String name;

    @Embedded
    private WorkLocation workLocation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    @OrderBy("createdDate desc")
    private List<Recruit> recruitList;

    public Recruit registerRecruit(RecruitId id, String position, int bounty, String details, String skill){
        Recruit newRecruit = new Recruit(id, this, position, new Money(bounty), details, skill, LocalDateTime.now(), LocalDateTime.now());
        return newRecruit;
    }

    public Recruit updateRecruit(RecruitId recruitId, String position, Integer bounty, String details, String skill) {
        Recruit recruit = this.recruitList.stream().filter((r) -> r.getId().equals(recruitId)).findFirst().orElseThrow(NotFoundRecruitException::new);
        boolean isUpdated = false;
        if(position!= null && !position.isBlank()) {
            recruit.setPosition(position);
            isUpdated = true;
        }
        if(bounty != null) {
            recruit.setBounty(new Money(bounty));
            isUpdated = true;
        }
        if(details != null && !details.isBlank()) {
            recruit.setDetails(details);
            isUpdated = true;
        }
        if(skill != null && !skill.isBlank()) {
            recruit.setSkills(skill);
            isUpdated = true;
        }
        if(isUpdated) recruit.setUpdatedDate(LocalDateTime.now());
        return recruit;
    }
}

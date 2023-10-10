package com.preonboarding.backend.recruit.model.domain.entity;

import com.preonboarding.backend.common.exception.NotDifferentBeforeState;
import com.preonboarding.backend.company.model.domain.entity.Company;
import com.preonboarding.backend.company.model.domain.vo.Money;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_recruit")
public class Recruit {

    @EmbeddedId
    private RecruitId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "recruit_position", length = 100, nullable = false)
    private String position;

    @Embedded
    private Money bounty;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(name = "recruit_skill")
    private String skills;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

    public void deleteCompany(){
        this.company.getRecruitList().remove(this);
        this.company = null;
    }

    public void updateRecruit(String position, Integer bounty, String details, String skill) throws NotDifferentBeforeState {
        boolean isUpdated = false;
        if (position != null && !position.isBlank() && !this.position.contentEquals(position)) {
            this.position = position;
            isUpdated = true;
        }
        Money inputMoney = new Money(bounty);
        if (!this.bounty.equals(inputMoney)) {
            this.bounty = inputMoney;
            isUpdated = true;
        }
        if (details != null && !details.isBlank() && !this.details.contentEquals(details)) {
            this.details = details;
            isUpdated = true;
        }
        if (skill != null && !skill.isBlank() && !this.skills.contentEquals(skill)) {
            this.skills = skill;
            isUpdated = true;
        }
        if (!isUpdated) throw new NotDifferentBeforeState();
        this.updatedDate = LocalDateTime.now();
    }
}

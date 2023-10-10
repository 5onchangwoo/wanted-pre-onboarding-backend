package com.preonboarding.backend.company.model.domain.entity;


import com.preonboarding.backend.company.model.domain.vo.CompanyId;
import com.preonboarding.backend.company.model.domain.vo.Money;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.company.model.domain.vo.WorkLocation;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.List;


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

    @Column(name = "delete_YN", nullable = false)
    private boolean isDelete;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    @OrderBy("createdDate desc")
    @BatchSize(size = 50)
    private List<Recruit> recruitList;

    public Recruit registerRecruit(RecruitId id, String position, int bounty, String details, String skill) {
        return new Recruit(id, this, position, new Money(bounty), details, skill, LocalDateTime.now(), LocalDateTime.now());
    }
}

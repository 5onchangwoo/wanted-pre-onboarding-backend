package com.preonboarding.backend.company.model.domain.entity;

import com.preonboarding.backend.company.model.domain.vo.Money;
import com.preonboarding.backend.company.model.domain.vo.RecruitId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Entity
@Table(name = "tbl_recruit")

public class Recruit {

    @EmbeddedId
    private RecruitId id;

    @ManyToOne(fetch = FetchType.EAGER)
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

    @Column(name = "updated_date", nullable = false, updatable = false)
    private LocalDateTime updatedDate;

}

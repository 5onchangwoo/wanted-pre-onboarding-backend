package com.preonboarding.backend.recruit.model.domain.entity;

import com.preonboarding.backend.recruit.model.domain.vo.ApplyToRecruitId;
import com.preonboarding.backend.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_apply_recruit")
@SequenceGenerator(name = "applyRecruitSeq", sequenceName = "apply_recruit_seq", allocationSize = 1)
public class ApplyRecruit {
    @EmbeddedId
    private ApplyToRecruitId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}

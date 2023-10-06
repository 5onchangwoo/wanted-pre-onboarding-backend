package com.preonboarding.backend.company.model.domain.vo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RecruitId implements Serializable {

    @Column(name = "recruit_id")
    private long seq;

}

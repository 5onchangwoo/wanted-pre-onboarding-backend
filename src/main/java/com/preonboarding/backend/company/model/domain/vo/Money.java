package com.preonboarding.backend.company.model.domain.vo;

import com.preonboarding.backend.common.exception.CannotMonetNegative;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money implements Serializable {
    private int value;

    public Money(int value) {
        if(value < 0) throw new CannotMonetNegative();
        this.value = value;
    }
}

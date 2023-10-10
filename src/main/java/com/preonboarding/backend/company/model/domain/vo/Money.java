package com.preonboarding.backend.company.model.domain.vo;

import com.preonboarding.backend.common.exception.CannotMoneyNegativeException;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money implements Serializable {
    private int value;

    public Money(int value) {
        if(value < 0) throw new CannotMoneyNegativeException();
        this.value = value;
    }
}

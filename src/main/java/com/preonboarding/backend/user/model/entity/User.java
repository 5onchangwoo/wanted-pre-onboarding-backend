package com.preonboarding.backend.user.model.entity;

import com.preonboarding.backend.user.model.vo.UserId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "tbl_user")
public class User {

    @EmbeddedId
    private UserId id;
}

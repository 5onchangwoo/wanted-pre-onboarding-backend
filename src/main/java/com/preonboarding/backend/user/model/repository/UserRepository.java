package com.preonboarding.backend.user.model.repository;

import com.preonboarding.backend.user.model.entity.User;
import com.preonboarding.backend.user.model.vo.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}

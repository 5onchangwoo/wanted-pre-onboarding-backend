package com.preonboarding.backend.recruit.model.repository;

import com.preonboarding.backend.recruit.model.domain.entity.ApplyRecruit;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.recruit.model.domain.vo.ApplyToRecruitId;
import com.preonboarding.backend.user.model.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplyRecruitRepository extends JpaRepository<ApplyRecruit, ApplyToRecruitId> {

    boolean existsApplyRecruitByRecruitAndUser(Recruit recruit, User user);

    @Query(nativeQuery = true, value = "select nextVal('apply_recruit_seq')")
    long nextSeq();
}

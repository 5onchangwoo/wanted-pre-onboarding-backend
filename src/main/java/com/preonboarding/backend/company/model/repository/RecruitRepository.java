package com.preonboarding.backend.company.model.repository;

import com.preonboarding.backend.company.model.domain.entity.Recruit;
import com.preonboarding.backend.company.model.domain.vo.RecruitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, RecruitId> {

    @Query(nativeQuery = true, value = "select nextVal('recruit_seq')")
    long nextSeq();

}

package com.preonboarding.backend.recruit.model.repository;

import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.dto.GetRecruitListResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, RecruitId> {

    @Query("select new com.preonboarding.backend.recruit.model.dto.GetRecruitListResponseDTO(r.id.seq, c.name, c.workLocation.nation, c.workLocation.region, r.position, r.bounty.value, r.skills) " +
            " from Recruit r " +
            " join r.company c " +
            "where c.name like %:condition% " +
            "   or r.position like %:condition% " +
            "   or r.skills like %:condition% " )
    Page<GetRecruitListResponseDTO> findRecruitListByCondition(Pageable pageable, @Param("condition") String condition);


    @Query("select r" +
            " from Recruit r " +
            " join fetch r.company c " +
            " join c.recruitList rl " +
            "where r.id = :id")
    Optional<Recruit> findRecruitDetailById(@Param("id") RecruitId id);

    @Query(nativeQuery = true, value = "select nextVal('recruit_seq')")
    long nextSeq();
}


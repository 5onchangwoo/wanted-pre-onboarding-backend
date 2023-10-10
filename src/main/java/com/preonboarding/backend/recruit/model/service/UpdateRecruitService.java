package com.preonboarding.backend.recruit.model.service;

import com.preonboarding.backend.common.exception.NotFoundRecruitException;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.dto.UpdateRecruitRequestDTO;
import com.preonboarding.backend.recruit.model.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateRecruitService {
    private final RecruitRepository recruitRepository;

    @Transactional
    public void updateRecruit(long recruitId, UpdateRecruitRequestDTO requestDTO) {
        // 채용 공고 존재 여부 확인
        Recruit recruit = recruitRepository.findById(new RecruitId(recruitId)).orElseThrow(NotFoundRecruitException::new);
        recruit.updateRecruit(requestDTO.getPosition(), requestDTO.getBounty(), requestDTO.getDetails(), requestDTO.getSkill());
    }

}

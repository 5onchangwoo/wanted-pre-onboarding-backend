package com.preonboarding.backend.recruit.model.service;

import com.preonboarding.backend.recruit.model.domain.vo.ApplyToRecruitId;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.repository.ApplyRecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyRecruitIdService {
    private final ApplyRecruitRepository applyRecruitRepository;

    public ApplyToRecruitId getNextId() {
        long seq = applyRecruitRepository.nextSeq();
        return new ApplyToRecruitId(seq);
    }
}

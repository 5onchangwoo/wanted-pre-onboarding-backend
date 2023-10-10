package com.preonboarding.backend.recruit.model.service;

import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitIdService {
    private final RecruitRepository recruitRepository;

    public RecruitId getNextId() {
        long seq = recruitRepository.nextSeq();
        return new RecruitId(seq);
    }
}

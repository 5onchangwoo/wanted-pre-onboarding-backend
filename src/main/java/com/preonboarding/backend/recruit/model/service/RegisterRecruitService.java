package com.preonboarding.backend.recruit.model.service;

import com.preonboarding.backend.common.exception.NotFoundCompanyException;
import com.preonboarding.backend.company.model.domain.entity.Company;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.company.model.domain.vo.CompanyId;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.company.model.dto.RegisterRecruitRequestDTO;
import com.preonboarding.backend.company.model.repository.CompanyRepository;
import com.preonboarding.backend.recruit.model.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterRecruitService {
    private final CompanyRepository companyRepository;
    private final RecruitRepository recruitRepository;
    private final RecruitIdService recruitIdService;

    @Transactional
    public long registerRecruit(long companyId, RegisterRecruitRequestDTO requestDTO){
        Company company = companyRepository.findById(new CompanyId(companyId)).orElseThrow(NotFoundCompanyException::new);
        RecruitId recruitId = recruitIdService.getNextId();
        Recruit newRecruit = company.registerRecruit(recruitId, requestDTO.getPosition(), requestDTO.getBounty(), requestDTO.getDetails(), requestDTO.getSkill());
        recruitRepository.save(newRecruit);
        return recruitId.getSeq();
    }
}

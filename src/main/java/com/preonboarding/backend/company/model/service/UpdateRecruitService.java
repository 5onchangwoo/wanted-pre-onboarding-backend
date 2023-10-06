package com.preonboarding.backend.company.model.service;

import com.preonboarding.backend.common.exception.NotFoundRecruitException;
import com.preonboarding.backend.company.model.domain.entity.Company;
import com.preonboarding.backend.company.model.domain.entity.Recruit;
import com.preonboarding.backend.company.model.domain.vo.CompanyId;
import com.preonboarding.backend.company.model.domain.vo.RecruitId;
import com.preonboarding.backend.company.model.dto.UpdateRecruitRequestDTO;
import com.preonboarding.backend.company.model.repository.CompanyRepository;
import com.preonboarding.backend.company.model.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateRecruitService {
    private final CompanyRepository companyRepository;
    private final RecruitRepository recruitRepository;

    @Transactional
    public boolean updateRecruit(long companyId, long recruitId, UpdateRecruitRequestDTO requestDTO) throws ChangeSetPersister.NotFoundException {
        // 해당 회사가 삭제된 것인지
        Company company = companyRepository.findById(new CompanyId(companyId)).orElseThrow(NotFoundRecruitException::new);
        // 해당
        Recruit recruit = company.updateRecruit(new RecruitId(recruitId), requestDTO.getPosition(), requestDTO.getBounty(), requestDTO.getDetails(), requestDTO.getSkill());
        return true;

    }

}

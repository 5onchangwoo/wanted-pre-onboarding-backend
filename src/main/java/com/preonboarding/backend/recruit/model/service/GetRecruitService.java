package com.preonboarding.backend.recruit.model.service;


import com.preonboarding.backend.recruit.model.dto.GetRecruitDetailResponseDTO;
import com.preonboarding.backend.recruit.model.dto.GetRecruitListResponseDTO;
import com.preonboarding.backend.recruit.model.dto.RecruitSearchConditionDTO;
import com.preonboarding.backend.common.exception.NotFoundRecruitException;
import com.preonboarding.backend.company.model.repository.CompanyRepository;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetRecruitService {
    private final CompanyRepository companyRepository;
    private final RecruitRepository recruitRepository;

    public Page<GetRecruitListResponseDTO> getRecruitList(RecruitSearchConditionDTO requestDTO, Pageable pageable) {
        Page<GetRecruitListResponseDTO> recruits = recruitRepository.findRecruitListByCondition(pageable, requestDTO.getSearch());
        return recruits;
    }

    public GetRecruitDetailResponseDTO getRecruitDetail(long recruitId) {

        RecruitId targetRecruitId = new RecruitId(recruitId);
        Recruit recruit = recruitRepository.findRecruitDetailById(targetRecruitId).orElseThrow(NotFoundRecruitException::new);
        return new GetRecruitDetailResponseDTO(
                recruit.getId().getSeq(),
                recruit.getCompany().getName(),
                recruit.getCompany().getWorkLocation().getNation(),
                recruit.getCompany().getWorkLocation().getRegion(),
                recruit.getPosition(),
                recruit.getBounty().getValue(),
                recruit.getSkills(),
                recruit.getDetails(),
                recruit.getCompany().getRecruitList().stream()
                        .filter(r -> !r.getId().equals(targetRecruitId))
                        .map(r -> r.getId().getSeq())
                        .collect(Collectors.toList())
        );
    }
}

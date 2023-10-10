package com.preonboarding.backend.recruit.model.service;

import com.preonboarding.backend.common.exception.NoMoreApplyRecruitException;
import com.preonboarding.backend.common.exception.NotFoundRecruitException;
import com.preonboarding.backend.common.exception.NotFoundUserException;
import com.preonboarding.backend.recruit.model.domain.entity.ApplyRecruit;
import com.preonboarding.backend.recruit.model.domain.entity.Recruit;
import com.preonboarding.backend.recruit.model.domain.vo.ApplyToRecruitId;
import com.preonboarding.backend.recruit.model.domain.vo.RecruitId;
import com.preonboarding.backend.recruit.model.repository.ApplyRecruitRepository;
import com.preonboarding.backend.recruit.model.repository.RecruitRepository;
import com.preonboarding.backend.user.model.entity.User;
import com.preonboarding.backend.user.model.repository.UserRepository;
import com.preonboarding.backend.user.model.vo.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplyRecruitService {
    private final ApplyRecruitIdService applyRecruitIdService;
    private final RecruitRepository recruitRepository;
    private final UserRepository userRepository;
    private final ApplyRecruitRepository applyRecruitRepository;

    public long applyRecruit(long recruitId, long userId){
        ApplyToRecruitId nextId = applyRecruitIdService.getNextId();
        Recruit recruit = recruitRepository.findById(new RecruitId(recruitId)).orElseThrow(NotFoundRecruitException::new);
        User user = userRepository.findById(new UserId(userId)).orElseThrow(NotFoundUserException::new);
        // 재지원 여부 확인
        if(applyRecruitRepository.existsApplyRecruitByRecruitAndUser(recruit, user)) throw new NoMoreApplyRecruitException();

        ApplyRecruit newApplyRecruit = new ApplyRecruit(nextId, recruit, user);
        applyRecruitRepository.save(newApplyRecruit);
        return nextId.getSeq();
    }

}

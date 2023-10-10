package com.preonboarding.backend.recruit.controller;

import com.preonboarding.backend.common.dto.*;
import com.preonboarding.backend.common.enumclass.CommonCode;
import com.preonboarding.backend.company.model.dto.RegisterRecruitRequestDTO;
import com.preonboarding.backend.recruit.model.dto.GetRecruitDetailResponseDTO;
import com.preonboarding.backend.recruit.model.dto.GetRecruitListResponseDTO;
import com.preonboarding.backend.recruit.model.dto.RecruitSearchConditionDTO;
import com.preonboarding.backend.recruit.model.dto.UpdateRecruitRequestDTO;
import com.preonboarding.backend.recruit.model.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/recruits")
@RequiredArgsConstructor
public class RecruitRestController {
    private final RegisterRecruitService registerRecruitService;
    private final GetRecruitService getRecruitService;
    private final UpdateRecruitService updateRecruitService;
    private final RemoveRecruitService removeRecruitService;
    private final ApplyRecruitService applyRecruitService;


    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAllRecruitList(RecruitSearchConditionDTO requestDTO,
                                                         @PageableDefault(size = 5, page = 0) Pageable pageable) {
        Page<GetRecruitListResponseDTO> recruitList = getRecruitService.getRecruitList(requestDTO, pageable);
        return ResponseEntity.ok(new ResponseDTO(CommonCode.SUCCESS, recruitList));
    }

    @GetMapping("{recruitNo}")
    public ResponseEntity<ResponseDTO> getRecruitDetails(@PathVariable long recruitNo) {
        GetRecruitDetailResponseDTO recruitDetail = getRecruitService.getRecruitDetail(recruitNo);
        return ResponseEntity.ok(new ResponseDTO(CommonCode.SUCCESS, recruitDetail));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO> registerRecruit(@RequestBody RegisterRecruitRequestDTO requestDTO) {

        // 현재 로그인한 사람의 회사로 채용공고를 올려야 하나 인증단계가 생략되어 json으로 받음
        long newRecruitId = registerRecruitService.registerRecruit(requestDTO.getCompanyId(), requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(CommonCode.SUCCESS, newRecruitId));
    }

    @PutMapping("{recruitNo}")
    public ResponseEntity<ResponseDTO> updateRecruit(@PathVariable long recruitNo,
                                                     @RequestBody UpdateRecruitRequestDTO requestDTO) {
        updateRecruitService.updateRecruit(recruitNo, requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(CommonCode.SUCCESS, recruitNo));
    }

    @DeleteMapping("{recruitNo}")
    public ResponseEntity<ResponseDTO> deleteRecruit(@PathVariable long recruitNo) {
        removeRecruitService.removeRecruit(recruitNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{recruitNo}/applications")
    public ResponseEntity<ResponseDTO> applyRecruit(@PathVariable long recruitNo) {
        // 현재 로그인 상태의 유저를 가져와야 하지만 여기서는 인증을 생략하였으므로 임의의 유저 삽입
        long userId = 1;
        long newApplyId = applyRecruitService.applyRecruit(recruitNo, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(CommonCode.SUCCESS, newApplyId));
    }


}

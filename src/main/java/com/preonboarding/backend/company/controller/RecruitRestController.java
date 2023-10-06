package com.preonboarding.backend.company.controller;

import com.preonboarding.backend.common.dto.ResponseDTO;
import com.preonboarding.backend.common.enumclass.CommonCode;
import com.preonboarding.backend.company.model.dto.RegisterRecruitRequestDTO;
import com.preonboarding.backend.company.model.dto.UpdateRecruitRequestDTO;
import com.preonboarding.backend.company.model.service.RegisterRecruitService;
import com.preonboarding.backend.company.model.service.UpdateRecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companys/{companyId}/recruits")
@RequiredArgsConstructor
public class RecruitRestController {
    private final RegisterRecruitService registerRecruitService;
    private final UpdateRecruitService updateRecruitService;

    @PostMapping("")
    public ResponseEntity<ResponseDTO> registerRecruit(@PathVariable long companyId,
                                                       @RequestBody RegisterRecruitRequestDTO requestDTO){

        long newRecruitId = registerRecruitService.registerRecruit(companyId, requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(CommonCode.SUCCESS, newRecruitId));
    }

    @PutMapping("{recruitNo}")
    public ResponseEntity<ResponseDTO> updateRecruit(@PathVariable long companyId,
                                                     @PathVariable long recruitNo,
                                                     @RequestBody UpdateRecruitRequestDTO requestDTO) throws ChangeSetPersister.NotFoundException {
        boolean result = updateRecruitService.updateRecruit(companyId, recruitNo, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(CommonCode.SUCCESS, null));
    }

}

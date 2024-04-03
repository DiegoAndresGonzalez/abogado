package com.proyecto.abogado.service;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.mapper.CaseMapper;
import com.proyecto.abogado.model.CaseModel;
import com.proyecto.abogado.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;

    public CaseModel createCase(CaseRequestDto caseRequestDto){
        CaseModel caseModel = caseMapper.toCaseModel(caseRequestDto);
        caseModel.setCreationDate(LocalDate.now());
        caseModel.setLastUpdate(LocalDate.now());
        caseModel.setStatus(true);
        caseRepository.save(caseModel);
        return caseModel;
    }

}
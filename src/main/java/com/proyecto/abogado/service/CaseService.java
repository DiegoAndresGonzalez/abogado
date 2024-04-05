package com.proyecto.abogado.service;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.mapper.CaseMapper;
import com.proyecto.abogado.model.CaseModel;
import com.proyecto.abogado.model.UserModel;
import com.proyecto.abogado.repository.CaseRepository;
import com.proyecto.abogado.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;
    private final UserRepository userRepository;

    public CaseModel createCase(CaseRequestDto caseRequestDto){
        UserModel userLawyer = userRepository.findByDni(caseRequestDto.getLawyer().getDni())
                .orElseThrow(()-> new RuntimeException("El usuario no existe."));
        CaseModel caseModel = caseMapper.toCaseModel(caseRequestDto);
        caseModel.setCreationDate(LocalDate.now());
        caseModel.setLawyer(userLawyer);
        caseModel.setLastUpdate(LocalDate.now());
        caseModel.setStatus(true);
        caseRepository.save(caseModel);
        return caseModel;
    }

}
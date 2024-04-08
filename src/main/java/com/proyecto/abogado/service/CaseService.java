package com.proyecto.abogado.service;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.mapper.CaseMapper;
import com.proyecto.abogado.model.CaseModel;
import com.proyecto.abogado.model.LawyerModel;
import com.proyecto.abogado.repository.CaseRepository;
import com.proyecto.abogado.repository.LawyerRepository;
import com.proyecto.abogado.security.TokenHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final CaseMapper caseMapper;
    private final LawyerRepository lawyerRepository;

    public CaseModel createCase(CaseRequestDto caseRequestDto){
        LawyerModel userLawyer = lawyerRepository.findByDni(TokenHolder.getDni())
                .orElseThrow(()-> new RuntimeException("El usuario no existe."));
        CaseModel caseModel = caseMapper.toCaseModel(caseRequestDto);
        caseModel.setLawyer(userLawyer);
        caseModel.setLastUpdate(LocalDate.now());
        caseModel.setStatus(true);
        caseRepository.save(caseModel);
        return caseModel;
    }

    public CaseModel updateCaseFile(Long id, MultipartFile file){
        CaseModel caseModel = caseRepository.findById(id).
                orElseThrow(()-> new RuntimeException("El caso no existe."));
        if (!TokenHolder.getDni().equals(caseModel.getLawyer().getDni())){
            throw new RuntimeException("Únicamente el abogado"
                    + caseModel.getLawyer().getFirstName() + " puede editar este caso.");
        }
        try {
            caseModel.setFile(file.getBytes());
        } catch (IOException e){
            throw new RuntimeException("Error al leer el archivo.");
        }
        caseRepository.save(caseModel);
        return caseModel;
    }

}
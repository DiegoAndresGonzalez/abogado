package com.proyecto.abogado.mapper;

import com.proyecto.abogado.dto.CaseRequestDto;
import com.proyecto.abogado.model.CaseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CaseMapper {

    public CaseModel toCaseModel(CaseRequestDto caseRequestDto);

}
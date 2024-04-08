package com.proyecto.abogado.mapper;

import com.proyecto.abogado.dto.ClientRequestDto;
import com.proyecto.abogado.dto.LawyerRequestDto;
import com.proyecto.abogado.model.ClientModel;
import com.proyecto.abogado.model.LawyerModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    LawyerModel toUserModel(LawyerRequestDto lawyerRequestDto);

    ClientModel toClientModel(ClientRequestDto clientRequestDto);
}
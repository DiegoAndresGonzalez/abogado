package com.proyecto.abogado.mapper;

import com.proyecto.abogado.dto.UserRequestDto;
import com.proyecto.abogado.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    public UserModel toUserModel(UserRequestDto userRequestDto);

}
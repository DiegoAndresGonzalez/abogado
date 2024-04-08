package com.proyecto.abogado.dto;

import com.proyecto.abogado.model.LawyerModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CaseRequestDto {

    private String name;
    private Date creationDate;
    private String description;

}
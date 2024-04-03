package com.proyecto.abogado.dto;

import com.proyecto.abogado.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CaseRequestDto {

    private String name;
    private String clientName;
    private UserModel lawyer;
    private byte[] file;

}
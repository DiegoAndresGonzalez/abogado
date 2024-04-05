package com.proyecto.abogado.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String dni;
    private String password;

}
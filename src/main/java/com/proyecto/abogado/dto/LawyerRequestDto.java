package com.proyecto.abogado.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LawyerRequestDto {

    private String firstName;
    private String lastName;
    private String dni;
    private String password;
    private String phone;
    private String address;
    private String email;

}
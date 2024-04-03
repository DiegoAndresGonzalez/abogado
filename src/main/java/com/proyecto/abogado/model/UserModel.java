package com.proyecto.abogado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "cédula")
    private String dni;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "teléfono")
    private String phone;

    @Column(name = "dirección")
    private String address;

    @Column(name = "correo")
    private String email;

    @Column(name = "cuenta")
    private String role;

    @OneToMany(mappedBy = "lawyer")
    @Column(name = "casos")
    private List<CaseModel> cases;
}
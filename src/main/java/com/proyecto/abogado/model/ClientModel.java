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
@Table(name = "cliente")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "cédula")
    private String dni;

    @Column(name = "teléfono")
    private String phone;

    @Column(name = "dirección")
    private String address;

    @Column(name = "correo")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "cuenta")
    private RoleModel role;

    @OneToMany(mappedBy = "client")
    @Column(name = "casos")
    private List<CaseModel> cases;

}
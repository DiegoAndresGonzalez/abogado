package com.proyecto.abogado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caso")
public class CaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "nombre_cliente")
    private String clientName;

    @Column(name = "estado")
    private boolean status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_creacion")
    private Date creationDate;

    @Column(name = "fecha_actualizacion")
    private LocalDate lastUpdate;

    @Lob
    @Column(name = "archivo", columnDefinition = "LONGBLOB")
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "abogado_id")
    private LawyerModel lawyer;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientModel client;
}
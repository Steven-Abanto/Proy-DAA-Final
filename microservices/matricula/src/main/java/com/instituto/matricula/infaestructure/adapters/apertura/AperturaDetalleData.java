package com.instituto.matricula.infaestructure.adapters.apertura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apertura_Detalle")
public class AperturaDetalleData {

    @Id
    @GeneratedValue
    private Long uid;

    @Column(name = "uid_apertura", length = 40)
    private String uidApertura;

    @Column(name = "uid_alumno", length = 40)
    private String uidAlumno;
}

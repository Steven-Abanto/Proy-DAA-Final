package com.instituto.matricula.infaestructure.adapters.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class CursoData {
    @Id
    @Column(length = 40)
    private String uid;

    @Column(name = "nombre", length = 60)
    private String name;

    @Column(name = "ciclo", length = 5)
    private String ciclo;

    @Column(name = "carrera", length = 60)
    private String carrera;

    public CursoData() {
    }

    public CursoData(String uid, String name, String ciclo, String carrera) {
        this.uid = uid;
        this.name = name;
        this.ciclo = ciclo;
        this.carrera = carrera;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

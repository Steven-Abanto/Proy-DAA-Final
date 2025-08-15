package com.instituto.matricula.infaestructure.adapters.apertura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apertura")
public class AperturaData {
    @Id
    @Column(length = 40)
    private String uid;

    @Column(name = "uid_curso", length = 40)
    private String uidCurso;

    @Column(name = "uid_profesor", length = 40)
    private String uidProfesor;

    public AperturaData() {
    }

    public AperturaData(String uid, String uidCurso, String uidProfesor) {
        this.uid = uid;
        this.uidCurso = uidCurso;
        this.uidProfesor = uidProfesor;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUidCurso() {
        return uidCurso;
    }

    public void setUidCurso(String uidCurso) {
        this.uidCurso = uidCurso;
    }

    public String getUidProfesor() {
        return uidProfesor;
    }

    public void setUidProfesor(String uidProfesor) {
        this.uidProfesor = uidProfesor;
    }
}

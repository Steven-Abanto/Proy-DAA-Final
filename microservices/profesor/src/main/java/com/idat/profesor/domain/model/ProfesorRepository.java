package com.idat.profesor.domain.model;

import java.util.List;

public interface ProfesorRepository {
    List<Profesor> getProfesores();
    Profesor findById(String id);
    Profesor save(Profesor profesor);
    Profesor update(String uid, Profesor profesor);
    void delete(String uid);
}

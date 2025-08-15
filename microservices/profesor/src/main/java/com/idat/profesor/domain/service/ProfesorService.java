package com.idat.profesor.domain.service;

import com.idat.profesor.domain.model.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> findAll();
    Profesor findById(String id);
    Profesor save(Profesor profesor);
    Profesor update(String uid, Profesor profesor);
    void delete(String id);
}

package com.instituto.matricula.domain.model.apertura;

import java.util.List;

public interface AperturaRepository {
    List<Apertura> findAll();
    Apertura findById(String uid);
    Apertura findByProfesorAndCurso(String uidProfesor, String uidCurso);
    Apertura save(Apertura apertura);
}

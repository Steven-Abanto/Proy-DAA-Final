package com.instituto.matricula.domain.model.curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> findAll();
    Curso findById(String id);
    Curso save(Curso curso);
}

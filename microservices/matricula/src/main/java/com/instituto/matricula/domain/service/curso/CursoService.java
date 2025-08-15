package com.instituto.matricula.domain.service.curso;

import com.instituto.matricula.domain.model.curso.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(String id);
    Curso save(Curso curso);
}

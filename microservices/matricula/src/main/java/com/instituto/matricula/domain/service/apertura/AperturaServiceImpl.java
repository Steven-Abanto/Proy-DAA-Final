package com.instituto.matricula.domain.service.apertura;

import com.instituto.matricula.domain.model.apertura.Apertura;
import com.instituto.matricula.domain.model.apertura.AperturaRepository;
import com.instituto.matricula.domain.model.curso.Curso;
import com.instituto.matricula.domain.model.curso.CursoRepository;
import com.instituto.matricula.domain.model.profesor.Profesor;
import com.instituto.matricula.domain.model.profesor.ProfesorRepository;
import com.instituto.matricula.infaestructure.adapters.apertura.AperturaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AperturaServiceImpl implements AperturaService {

    private final AperturaRepository aperturaRepository;
    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;

    public AperturaServiceImpl(AperturaRepository aperturaRepository, CursoRepository cursoRepository, ProfesorRepository profesorRepository) {
        this.aperturaRepository = aperturaRepository;
        this.cursoRepository = cursoRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Apertura> findAll() {
        return aperturaRepository.findAll();
    }

    @Override
    public Apertura findById(String uid) {
        return aperturaRepository.findById(uid);
    }

    @Override
    public Apertura save(Apertura apertura) {
        Curso curso = cursoRepository.findById(apertura.uidCurso());
        Profesor profesor = profesorRepository.findById(apertura.uidProfesor());
        if(curso != null && profesor != null){
            return aperturaRepository.save(apertura);
        }
        return null;
    }
}

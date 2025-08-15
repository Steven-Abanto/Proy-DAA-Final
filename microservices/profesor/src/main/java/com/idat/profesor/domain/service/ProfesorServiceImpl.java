package com.idat.profesor.domain.service;

import com.idat.profesor.domain.model.Profesor;
import com.idat.profesor.domain.model.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.getProfesores();
    }

    @Override
    public Profesor findById(String id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(String uid, Profesor profesor) {
        return profesorRepository.update(uid, profesor);
    }

    @Override
    public void delete(String id) {
        profesorRepository.delete(id);
    }
}

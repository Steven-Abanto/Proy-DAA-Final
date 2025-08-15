package com.idat.profesor.infraestructure.adapter.profesor;

import com.idat.profesor.domain.model.Profesor;
import com.idat.profesor.domain.model.ProfesorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfesorAdapter implements ProfesorRepository {

    private final ProfesorDataRepository profesorDataRepository;

    public ProfesorAdapter(ProfesorDataRepository profesorDataRepository) {
        this.profesorDataRepository = profesorDataRepository;
    }

    @Override
    public List<Profesor> getProfesores() {
        return profesorDataRepository.findAll()
                .stream()
                .filter(profesorData -> profesorData.getActive() == 1)
                .map(ProfesorMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Profesor findById(String id) {
        Optional<ProfesorData> profesorOptional = profesorDataRepository.findById(id);
        if(profesorOptional.isPresent()) {
            if(profesorOptional.get().getActive() == 1) {
                return ProfesorMapper.MAPPER.toModel(profesorOptional.get());
            }
        }

        return null;
    }

    @Override
    public Profesor save(Profesor profesor) {
        ProfesorData profesorData = profesorDataRepository.save(ProfesorMapper.MAPPER.toEntity(profesor));
        return ProfesorMapper.MAPPER.toModel(profesorData);
    }

    @Override
    public Profesor update(String uid, Profesor profesor) {
        Optional<ProfesorData> profesorData = profesorDataRepository.findById(uid);
        if (profesorData.isPresent()) {
            ProfesorData profesorPresent = ProfesorMapper.MAPPER.toEntity(profesor);
            return ProfesorMapper.MAPPER.toModel(profesorDataRepository.save(profesorPresent));
        }

        return null;
    }

    @Override
    public void delete(String uid) {
        Optional<ProfesorData> profesor = profesorDataRepository.findById(uid);
        if (profesor.isPresent()) {
            ProfesorData profesorData = profesor.get();
            profesorData.setActive(0);
            profesorDataRepository.save(profesorData);
        }
    }
}

package com.instituto.matricula.infaestructure.adapters.curso;

import com.instituto.matricula.domain.model.curso.Curso;
import com.instituto.matricula.domain.model.curso.CursoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CursoAdapter implements CursoRepository {
    private final CursoDataRepository cursoDataRepository;

    public CursoAdapter(CursoDataRepository cursoDataRepository) {
        this.cursoDataRepository = cursoDataRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoDataRepository.findAll()
                .stream()
                .map(CursoMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Curso findById(String id) {
        Optional<CursoData> cursoOptional = cursoDataRepository.findById(id);
        return cursoOptional.map(CursoMapper.MAPPER::toModel).orElse(null);
    }

    @Override
    public Curso save(Curso curso) {
        CursoData cursoData = CursoMapper.MAPPER.toData(curso);
        return CursoMapper.MAPPER.toModel(cursoDataRepository.save(cursoData));
    }
}

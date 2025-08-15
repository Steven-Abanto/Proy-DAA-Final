package com.instituto.matricula.infaestructure.adapters.apertura;

import com.instituto.matricula.domain.model.apertura.Apertura;
import com.instituto.matricula.domain.model.apertura.AperturaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AperturaAdapter implements AperturaRepository {
    private final AperturaDataRepository aperturaDataRepository;

    public AperturaAdapter(AperturaDataRepository aperturaDataRepository) {
        this.aperturaDataRepository = aperturaDataRepository;
    }

    @Override
    public List<Apertura> findAll() {
        return aperturaDataRepository
                .findAll()
                .stream()
                .map(AperturaMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Apertura findById(String uid) {
        Optional<AperturaData> optional = aperturaDataRepository.findById(uid);
        return optional.map(AperturaMapper.MAPPER::toModel).orElse(null);
    }

    @Override
    public Apertura findByProfesorAndCurso(String uidProfesor, String uidCurso) {
        return null;
    }

    @Override
    public Apertura save(Apertura apertura) {
        AperturaData data = AperturaMapper.MAPPER.toData(apertura);
        return AperturaMapper.MAPPER.toModel(aperturaDataRepository.save(data));
    }
}

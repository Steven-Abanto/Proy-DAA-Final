package com.instituto.matricula.infaestructure.adapters.apertura;

import com.instituto.matricula.domain.model.apertura.AperturaDetalle;
import com.instituto.matricula.domain.model.apertura.AperturaDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AperturaDetalleAdapter implements AperturaDetalleRepository {

    private final AperturaDetalleDataRepository aperturaDetalleDataRepository;

    public AperturaDetalleAdapter(AperturaDetalleDataRepository aperturaDetalleDataRepository) {
        this.aperturaDetalleDataRepository = aperturaDetalleDataRepository;
    }


    @Override
    public List<AperturaDetalle> findByAperturaId(String uidApertura) {
        return aperturaDetalleDataRepository.findByUidApertura(uidApertura)
                .stream()
                .map(AperturaDetalleMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public List<AperturaDetalle> findByStudentId(String uidStudent) {
        return aperturaDetalleDataRepository.findByUidAlumno(uidStudent)
                .stream()
                .map(AperturaDetalleMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public AperturaDetalle save(AperturaDetalle aperturaDetalle) {
        AperturaDetalleData data  = AperturaDetalleMapper.MAPPER.toData(aperturaDetalle);
        return AperturaDetalleMapper.MAPPER
                .toModel(aperturaDetalleDataRepository.save(data));
    }
}

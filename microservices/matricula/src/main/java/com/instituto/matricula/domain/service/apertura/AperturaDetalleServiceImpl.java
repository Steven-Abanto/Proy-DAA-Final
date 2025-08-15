package com.instituto.matricula.domain.service.apertura;

import com.instituto.matricula.domain.model.apertura.AperturaDetalle;
import com.instituto.matricula.domain.model.apertura.AperturaDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AperturaDetalleServiceImpl implements AperturaDetalleService {

    private final AperturaDetalleRepository aperturaDetalleRepository;

    public AperturaDetalleServiceImpl(AperturaDetalleRepository aperturaDetalleRepository) {
        this.aperturaDetalleRepository = aperturaDetalleRepository;
    }

    @Override
    public List<AperturaDetalle> findByAperturaId(String uidApertura) {
        return aperturaDetalleRepository.findByAperturaId(uidApertura);
    }

    @Override
    public List<AperturaDetalle> findByStudentId(String uidStudent) {
        return aperturaDetalleRepository.findByStudentId(uidStudent);
    }

    @Override
    public AperturaDetalle save(AperturaDetalle aperturaDetalle) {
        return aperturaDetalleRepository.save(aperturaDetalle);
    }
}

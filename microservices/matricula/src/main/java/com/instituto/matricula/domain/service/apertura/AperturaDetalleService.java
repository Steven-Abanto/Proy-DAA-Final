package com.instituto.matricula.domain.service.apertura;

import com.instituto.matricula.domain.model.apertura.AperturaDetalle;

import java.util.List;

public interface AperturaDetalleService {
    List<AperturaDetalle> findByAperturaId(String uidApertura);
    List<AperturaDetalle> findByStudentId(String uidStudent);
    AperturaDetalle save(AperturaDetalle aperturaDetalle);
}

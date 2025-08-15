package com.instituto.matricula.domain.service.apertura;

import com.instituto.matricula.domain.model.apertura.Apertura;

import java.util.List;

public interface AperturaService {
    List<Apertura> findAll();
    Apertura findById(String uid);
    Apertura save(Apertura apertura);
}

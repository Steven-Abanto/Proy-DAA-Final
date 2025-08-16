package com.idat.movimiento.domain.service;

import com.idat.movimiento.domain.model.Movimiento;
import java.util.List;

public interface MovimientoService {
    List<Movimiento> findAll();
    Movimiento findById(int uid);
    Movimiento save(Movimiento movimiento);
    Movimiento update(int uid, Movimiento movimiento);
    void delete(int uid);
}

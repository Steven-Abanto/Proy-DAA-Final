package com.idat.movimiento.domain.model;

import java.util.List;

public interface MovimientoRepository {
    List<Movimiento> findAll();

    Movimiento findById(int uid);

    Movimiento save(Movimiento movimiento);

    Movimiento update(int uid, Movimiento movimiento);

    void delete(int uid);
}

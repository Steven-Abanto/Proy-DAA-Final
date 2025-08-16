package com.idat.cuenta.domain.model;

import java.util.List;

public interface CuentaRepository {
    List<Cuenta> findAll();

    Cuenta findById(String uid);

    Cuenta save(Cuenta cuenta);

    Cuenta update(String uid, Cuenta cuenta);

    void delete(String uid);
}

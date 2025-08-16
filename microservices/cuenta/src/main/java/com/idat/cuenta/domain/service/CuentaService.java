package com.idat.cuenta.domain.service;

import com.idat.cuenta.domain.model.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta> findAll();
    Cuenta findById(String uid);
    Cuenta save(Cuenta cuenta);
    Cuenta update(String uid, Cuenta cuenta);
    void delete(String uid);
}

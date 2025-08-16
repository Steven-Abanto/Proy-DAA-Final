package com.idat.cuenta.domain.service;

import com.idat.cuenta.domain.model.Cuenta;
import com.idat.cuenta.domain.model.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta findById(String uid) {
        return cuentaRepository.findById(uid);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta update(String uid, Cuenta cuenta) {
        return cuentaRepository.update(uid, cuenta);
    }

    @Override
    public void delete(String uid) {
        cuentaRepository.delete(uid);
    }
}

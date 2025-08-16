package com.idat.cuenta.domain.service;

import com.idat.cuenta.domain.model.Cuenta;
import com.idat.cuenta.domain.model.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
        String nro = cuenta.nroCuenta();
        if (nro == null || nro.isBlank()) {
            nro = generarNroCuentaUnica();
        }

        // Record es inmutable: construimos uno nuevo con el nroCuenta final
        Cuenta toSave = new Cuenta(
                cuenta.uid(),
                nro,
                cuenta.tipoCuenta(),
                cuenta.saldo(),
                cuenta.compraInt()
        );

        return cuentaRepository.save(toSave);
    }

    @Override
    public Cuenta update(String uid, Cuenta cuenta) {
        return cuentaRepository.update(uid, cuenta);
    }

    @Override
    public void delete(String uid) {
        cuentaRepository.delete(uid);
    }

    private String generarNroCuentaUnica() {
        final String prefix = "001234567890";
        String nro;
        do {
            int n = ThreadLocalRandom.current().nextInt(0, 1_000_000);
            nro = prefix + String.format("%06d", n);
        } while (cuentaRepository.existsByNroCuenta(nro)); // requiere este método en el repo de dominio
        return nro;
    }
}

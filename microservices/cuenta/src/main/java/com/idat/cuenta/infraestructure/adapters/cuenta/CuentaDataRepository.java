package com.idat.cuenta.infraestructure.adapters.cuenta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaDataRepository extends JpaRepository<CuentaData, Integer> {
    boolean existsByNroCuenta(String nroCuenta);
}

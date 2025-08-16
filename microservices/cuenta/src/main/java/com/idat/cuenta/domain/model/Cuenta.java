package com.idat.cuenta.domain.model;

public record Cuenta(
        String uid,
        String nroCuenta,
        String tipoCuenta,
        double saldo,
        boolean compraInt
) {
}

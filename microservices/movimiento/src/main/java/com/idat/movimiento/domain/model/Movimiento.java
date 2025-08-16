package com.idat.movimiento.domain.model;

import java.time.LocalDate;

public record Movimiento(
        int uid,
        String cuentaOrigen,
        String cuentaDestin,
        double monto,
        LocalDate fecha
) {
}

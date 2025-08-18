package com.idat.prestamos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrestamoDetalle(
        String uid,
        Integer  uid_prestamo,
        String uidCuenta,
        BigDecimal montoPrestamo,
        BigDecimal tasaInt,
        int cuotas,
        BigDecimal deuda_cuota,
        BigDecimal deuda_total,
        LocalDate fecha
) {
}

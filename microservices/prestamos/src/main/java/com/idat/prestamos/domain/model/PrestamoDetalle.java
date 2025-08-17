package com.idat.prestamos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrestamoDetalle(
        int uid,
        int uid_prestamo,
        Long uidCuenta,
        BigDecimal montoPrestamo,
        BigDecimal tasaInt,
        int cuotas,
        BigDecimal deuda_cuota,
        BigDecimal deuda_total,
        LocalDate fecha
) {
}

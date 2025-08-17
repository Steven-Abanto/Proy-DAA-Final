package com.idat.prestamos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Prestamos(
        int uid,
        String tipoPrestamo,
        BigDecimal monto,
        LocalDate fecha
) {
}



package com.idat.prestamos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Prestamos(
        Integer uid,
        String tipoPrestamo,
        BigDecimal monto,
        LocalDate fecha
) {
}



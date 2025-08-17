package com.idat.prestamos.infraestructure.entries;

import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.model.PrestamoDetalle;

import java.util.List;

public class PrestamoConDetalles {

    private Prestamos prestamo;
    private List<PrestamoDetalle> detalles;

    public Prestamos getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }

    public List<PrestamoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PrestamoDetalle> detalles) {
        this.detalles = detalles;
    }
}

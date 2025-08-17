package com.idat.prestamos.domain.service;

import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.model.PrestamoDetalle;
import java.util.List;

public interface PrestamosService {
    List<Prestamos> findAll();
    Prestamos findById(int uid);
    Prestamos save(Prestamos prestamos);
    Prestamos update(int uid, Prestamos prestamos);
    void delete(int uid);
    Prestamos crearPrestamoConDetalle(Prestamos prestamo, List<PrestamoDetalle> detalles);

}

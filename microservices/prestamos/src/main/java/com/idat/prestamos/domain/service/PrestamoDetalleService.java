package com.idat.prestamos.domain.service;
import com.idat.prestamos.domain.model.PrestamoDetalle;
import java.util.List;

public interface PrestamoDetalleService {
    List<PrestamoDetalle> findAll();
    PrestamoDetalle findById(String uid);
    PrestamoDetalle save(PrestamoDetalle prestamoDetalle);
    PrestamoDetalle update(String uid, PrestamoDetalle prestamoDetalle);
    void delete(String uid);
}

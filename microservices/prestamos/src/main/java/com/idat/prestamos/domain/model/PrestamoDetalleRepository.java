package com.idat.prestamos.domain.model;
import java.util.List;

public interface PrestamoDetalleRepository {

    List<PrestamoDetalle> findAll();

    PrestamoDetalle findById(String uid);

    PrestamoDetalle save(PrestamoDetalle detalle);

    PrestamoDetalle update(String uid, PrestamoDetalle detalle);

    void delete(String uid);
}

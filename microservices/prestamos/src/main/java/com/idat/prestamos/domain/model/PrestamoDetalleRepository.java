package com.idat.prestamos.domain.model;
import java.util.List;

public interface PrestamoDetalleRepository {

    List<PrestamoDetalle> findAll();

    PrestamoDetalle findById(int uid);

    PrestamoDetalle save(PrestamoDetalle detalle);

    PrestamoDetalle update(int uid, PrestamoDetalle detalle);

    void delete(int uid);
}

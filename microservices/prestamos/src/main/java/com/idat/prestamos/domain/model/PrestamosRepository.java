package com.idat.prestamos.domain.model;

import java.util.List;

public interface PrestamosRepository {
    List<Prestamos> findAll();

    Prestamos findById(int uid);

    Prestamos save(Prestamos prestamos);

    Prestamos update(int uid, Prestamos prestamos);

    void delete(int uid);
}

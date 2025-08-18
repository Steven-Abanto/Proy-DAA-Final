package com.idat.prestamos.domain.model;

import java.util.List;

public interface PrestamosRepository {
    List<Prestamos> findAll();

    Prestamos findById(String uid);

    Prestamos save(Prestamos prestamos);

    Prestamos update(String uid, Prestamos prestamos);

    void delete(String uid);
}

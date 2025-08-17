package com.idat.prestamos.domain.service;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.model.PrestamosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosServiceImpl implements PrestamosService {

    private final PrestamosRepository prestamosRepository;

    public PrestamosServiceImpl(PrestamosRepository prestamosRepository) {
        this.prestamosRepository = prestamosRepository;
    }

    @Override
    public List<Prestamos> findAll() {
        return prestamosRepository.findAll();
    }

    @Override
    public Prestamos findById(int uid) {
        return prestamosRepository.findById(uid);
    }

    @Override
    public Prestamos save(Prestamos prestamos) {
        return prestamosRepository.save(prestamos);
    }

    @Override
    public Prestamos update(int uid, Prestamos prestamos) {
        return prestamosRepository.update(uid, prestamos);
    }

    @Override
    public void delete(int uid) {
        prestamosRepository.delete(uid);
    }

    @Override
    public Prestamos crearPrestamoConDetalle(Prestamos prestamo, List<PrestamoDetalle> detalles) {
        return null;
    }
}

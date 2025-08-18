package com.idat.prestamos.domain.service;


import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.PrestamoDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoDetalleServiceImpl implements PrestamoDetalleService{

    private final PrestamoDetalleRepository prestamoDetalleRepository;

    public PrestamoDetalleServiceImpl(PrestamoDetalleRepository prestamoDetalleRepository) {
        this.prestamoDetalleRepository = prestamoDetalleRepository;
    }

    @Override
    public List<PrestamoDetalle> findAll() { return prestamoDetalleRepository.findAll();}

    @Override
    public PrestamoDetalle findById(String uid) { return prestamoDetalleRepository.findById(uid);}

    @Override
    public PrestamoDetalle save(PrestamoDetalle prestamoDetalle) { return prestamoDetalleRepository.save(prestamoDetalle);}

    @Override
    public PrestamoDetalle update(String uid, PrestamoDetalle prestamoDetalle) { return prestamoDetalleRepository.update(uid, prestamoDetalle);}

    @Override
    public void delete(String uid) {prestamoDetalleRepository.delete(uid);}
}

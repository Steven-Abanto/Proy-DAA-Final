package com.idat.movimiento.domain.service;

import com.idat.movimiento.domain.model.Movimiento;
import com.idat.movimiento.domain.model.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento findById(int uid) {
        return movimientoRepository.findById(uid);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento update(int uid, Movimiento movimiento) {
        return movimientoRepository.update(uid, movimiento);
    }

    @Override
    public void delete(int uid) {
        movimientoRepository.delete(uid);
    }
}

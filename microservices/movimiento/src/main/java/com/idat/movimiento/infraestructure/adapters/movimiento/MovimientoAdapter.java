package com.idat.movimiento.infraestructure.adapters.movimiento;

import com.idat.movimiento.domain.model.Movimiento;
import com.idat.movimiento.domain.model.MovimientoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovimientoAdapter implements MovimientoRepository {

    private final MovimientoDataRepository movimientoDataRepository;

    public MovimientoAdapter(MovimientoDataRepository movimientoDataRepository) {
        this.movimientoDataRepository = movimientoDataRepository;
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoDataRepository.findAll()
                .stream()
                .map(MovimientoMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Movimiento findById(int uid) {
        Optional<MovimientoData> movimientoData = movimientoDataRepository.findById(uid);
        return movimientoData.map(MovimientoMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        MovimientoData movimientoData = movimientoDataRepository.save(MovimientoMapper.MAPPER.toEntity(movimiento));
        return MovimientoMapper.MAPPER.toDomain(movimientoData);
    }

    @Override
    public Movimiento update(int uid, Movimiento movimiento) {
        Optional<MovimientoData> movimientoData = movimientoDataRepository.findById(uid);
        if (movimientoData.isPresent()) {
            MovimientoData entity = MovimientoMapper.MAPPER.toEntity(movimiento);
            entity.setUid(uid);
            return MovimientoMapper.MAPPER.toDomain(movimientoDataRepository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(int uid) {
        movimientoDataRepository.deleteById(uid);
    }
}

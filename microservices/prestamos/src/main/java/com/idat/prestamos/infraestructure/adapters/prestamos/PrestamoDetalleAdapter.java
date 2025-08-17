package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.PrestamoDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrestamoDetalleAdapter implements PrestamoDetalleRepository {

    private final PrestamoDetalleDataRepository prestamoDetalleDataRepository;

    public PrestamoDetalleAdapter(PrestamoDetalleDataRepository prestamoDetalleDataRepository) {
        this.prestamoDetalleDataRepository = prestamoDetalleDataRepository;
    }

    @Override
    public List<PrestamoDetalle> findAll() {
        return prestamoDetalleDataRepository.findAll()
                .stream()
                .map(PrestamoDetalleMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public PrestamoDetalle findById(int uid) {
        Optional<PrestamoDetalleData> detalleData = prestamoDetalleDataRepository.findById(uid);
        return detalleData.map(PrestamoDetalleMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public PrestamoDetalle save(PrestamoDetalle prestamoDetalle) {
        PrestamoDetalleData data = PrestamoDetalleMapper.MAPPER.toEntity(prestamoDetalle);
        PrestamoDetalleData saved = prestamoDetalleDataRepository.save(data);
        return PrestamoDetalleMapper.MAPPER.toDomain(saved);
    }

    @Override
    public PrestamoDetalle update(int uid, PrestamoDetalle prestamoDetalle) {
        Optional<PrestamoDetalleData> detalleData = prestamoDetalleDataRepository.findById(uid);
        if (detalleData.isPresent()) {
            PrestamoDetalleData entity = PrestamoDetalleMapper.MAPPER.toEntity(prestamoDetalle);
            entity.setUid(uid);
            PrestamoDetalleData updated = prestamoDetalleDataRepository.save(entity);
            return PrestamoDetalleMapper.MAPPER.toDomain(updated);
        }
        return null;
    }

    @Override
    public void delete(int uid) {
        prestamoDetalleDataRepository.deleteById(uid);
    }
}


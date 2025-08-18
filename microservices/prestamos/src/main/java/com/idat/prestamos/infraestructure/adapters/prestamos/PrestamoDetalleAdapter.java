package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.PrestamoDetalleRepository;
import com.idat.prestamos.domain.service.PrestamoDetalleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Primary
@Component
public class PrestamoDetalleAdapter implements PrestamoDetalleRepository, PrestamoDetalleService {

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
    public PrestamoDetalle findById(String uid) {
        Optional<PrestamoDetalleData> detalleData = prestamoDetalleDataRepository.findById(Integer.valueOf(uid));
        return detalleData.map(PrestamoDetalleMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public PrestamoDetalle save(PrestamoDetalle prestamoDetalle) {
        // Usa el mapper de creación (debes tener toNewEntity en el mapper)
        PrestamoDetalleData data = PrestamoDetalleMapper.MAPPER.toNewEntity(prestamoDetalle);

        // Cinturón y tirantes: garantizar INSERT
        data.setUid(null);

        // Validaciones básicas
        BigDecimal monto = data.getMontoPrestamo();
        BigDecimal tasa  = data.getTasaInt();
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("montoPrestamo debe ser > 0");
        if (tasa == null)
            throw new IllegalArgumentException("tasaInt es requerida");
        if (data.getCuotas() <= 0)
            throw new IllegalArgumentException("cuotas debe ser > 0");

        // deuda_total = monto + (monto * tasa / 100)
        BigDecimal deudaTotal = monto.add(
                monto.multiply(tasa).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)
        );
        data.setDeuda_total(deudaTotal);

        // deuda_cuota = deuda_total / cuotas
        BigDecimal deudaCuota = deudaTotal.divide(new BigDecimal(data.getCuotas()), 2, RoundingMode.HALF_UP);
        data.setDeuda_cuota(deudaCuota);

        PrestamoDetalleData saved = prestamoDetalleDataRepository.save(data);
        return PrestamoDetalleMapper.MAPPER.toDomain(saved);
    }

    @Override
    public PrestamoDetalle update(String uid, PrestamoDetalle prestamoDetalle) {
        Optional<PrestamoDetalleData> detalleData = prestamoDetalleDataRepository.findById(Integer.valueOf(uid));
        if (detalleData.isPresent()) {
            PrestamoDetalleData entity = PrestamoDetalleMapper.MAPPER.toEntity(prestamoDetalle);
            entity.setUid(Integer.valueOf(uid));
            PrestamoDetalleData updated = prestamoDetalleDataRepository.save(entity);
            return PrestamoDetalleMapper.MAPPER.toDomain(updated);
        }
        return null;
    }

    @Override
    public void delete(String uid) {
        prestamoDetalleDataRepository.deleteById(Integer.valueOf(uid));
    }
}


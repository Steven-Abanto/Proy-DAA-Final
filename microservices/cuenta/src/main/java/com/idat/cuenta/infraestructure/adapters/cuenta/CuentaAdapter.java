package com.idat.cuenta.infraestructure.adapters.cuenta;

import com.idat.cuenta.domain.model.Cuenta;
import com.idat.cuenta.domain.model.CuentaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CuentaAdapter implements CuentaRepository {

    private final CuentaDataRepository cuentaDataRepository;

    public CuentaAdapter(CuentaDataRepository cuentaDataRepository) {
        this.cuentaDataRepository = cuentaDataRepository;
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaDataRepository.findAll()
                .stream()
                .map(CuentaMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Cuenta findById(String uid) {
        Optional<CuentaData> cuentaData = cuentaDataRepository.findById(Integer.valueOf(uid));
        return cuentaData.map(CuentaMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        CuentaData cuentaData = cuentaDataRepository.save(CuentaMapper.MAPPER.toEntity(cuenta));
        return CuentaMapper.MAPPER.toDomain(cuentaData);
    }

    @Override
    public Cuenta update(String uid, Cuenta cuenta) {
        Optional<CuentaData> cuentaData = cuentaDataRepository.findById(Integer.valueOf(uid));
        if (cuentaData.isPresent()) {
            CuentaData nuevaCuenta = CuentaMapper.MAPPER.toEntity(cuenta);
            nuevaCuenta.setUid(Integer.valueOf(uid)); // aseguramos que se actualice el mismo registro
            return CuentaMapper.MAPPER.toDomain(cuentaDataRepository.save(nuevaCuenta));
        }
        return null;
    }

    @Override
    public void delete(String uid) {
        cuentaDataRepository.deleteById(Integer.valueOf(uid));
    }
}

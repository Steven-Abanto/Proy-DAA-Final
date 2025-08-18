package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.model.PrestamosRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrestamosAdapter implements PrestamosRepository {

    private final PrestamosDataRepository prestamosDataRepository;

    public PrestamosAdapter(PrestamosDataRepository prestamosDataRepository) {
        this.prestamosDataRepository = prestamosDataRepository;
    }

    @Override
    public List<Prestamos> findAll() {
        return prestamosDataRepository.findAll()
                .stream()
                .map(PrestamosMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Prestamos findById(String uid) {
        Optional<PrestamosData> prestamosData = prestamosDataRepository.findById(Integer.valueOf(uid));
        return prestamosData.map(PrestamosMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public Prestamos save(Prestamos prestamos) {
        PrestamosData entity = PrestamosMapper.MAPPER.toNewEntity(prestamos);
        entity.setUid(null); // cinturón y tirantes, garantiza INSERT

        PrestamosData saved = prestamosDataRepository.save(entity);
        return PrestamosMapper.MAPPER.toDomain(saved);
    }

    @Override
    public Prestamos update(String uid, Prestamos prestamos) {
        Optional<PrestamosData> prestamosData = prestamosDataRepository.findById(Integer.valueOf(uid));
        if (prestamosData.isPresent()) {
            PrestamosData entity = PrestamosMapper.MAPPER.toEntity(prestamos);
            entity.setUid(Integer.valueOf(uid));
            return PrestamosMapper.MAPPER.toDomain(prestamosDataRepository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(String uid) {
        prestamosDataRepository.deleteById(Integer.valueOf(uid));
    }
}

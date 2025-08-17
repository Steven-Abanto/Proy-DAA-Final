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
    public Prestamos findById(int uid) {
        Optional<PrestamosData> prestamosData = prestamosDataRepository.findById(uid);
        return prestamosData.map(PrestamosMapper.MAPPER::toDomain).orElse(null);
    }

    @Override
    public Prestamos save(Prestamos prestamos) {
        PrestamosData prestamosData = prestamosDataRepository.save(PrestamosMapper.MAPPER.toEntity(prestamos));
        return PrestamosMapper.MAPPER.toDomain(prestamosData);
    }

    @Override
    public Prestamos update(int uid, Prestamos prestamos) {
        Optional<PrestamosData> prestamosData = prestamosDataRepository.findById(uid);
        if (prestamosData.isPresent()) {
            PrestamosData entity = PrestamosMapper.MAPPER.toEntity(prestamos);
            entity.setUid(uid);
            return PrestamosMapper.MAPPER.toDomain(prestamosDataRepository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(int uid) {
        prestamosDataRepository.deleteById(uid);
    }
}

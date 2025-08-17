package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrestamoDetalleMapper {
    PrestamoDetalleMapper MAPPER = Mappers.getMapper(PrestamoDetalleMapper.class);

    // Convierte de entidad (base de datos) a dominio
    PrestamoDetalle toDomain(PrestamoDetalleData entity);

    // Convierte de dominio a entidad (para guardar en la BD)
    PrestamoDetalleData toEntity(PrestamoDetalle domain);
}

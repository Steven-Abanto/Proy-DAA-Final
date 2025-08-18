package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrestamoDetalleMapper {
    PrestamoDetalleMapper MAPPER = Mappers.getMapper(PrestamoDetalleMapper.class);

    PrestamoDetalle toDomain (PrestamoDetalleData entity);

    PrestamoDetalleData toEntity (PrestamoDetalle domain);


}

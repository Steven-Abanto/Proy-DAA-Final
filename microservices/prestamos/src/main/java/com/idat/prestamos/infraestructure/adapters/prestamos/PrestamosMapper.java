package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.Prestamos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrestamosMapper {
    PrestamosMapper MAPPER = Mappers.getMapper(PrestamosMapper.class);

    Prestamos toDomain(PrestamosData entity);
    PrestamosData toEntity(Prestamos domain);
}

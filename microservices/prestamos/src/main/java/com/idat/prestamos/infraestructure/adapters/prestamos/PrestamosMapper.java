package com.idat.prestamos.infraestructure.adapters.prestamos;

import com.idat.prestamos.domain.model.Prestamos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrestamosMapper {
    PrestamosMapper MAPPER = Mappers.getMapper(PrestamosMapper.class);

    Prestamos toDomain(PrestamosData entity);

    @Mapping(target = "uid", ignore = true)
    PrestamosData toNewEntity(Prestamos domain);

    PrestamosData toEntity(Prestamos domain);
}

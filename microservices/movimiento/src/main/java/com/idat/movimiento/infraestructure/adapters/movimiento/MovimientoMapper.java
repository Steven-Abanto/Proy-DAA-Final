package com.idat.movimiento.infraestructure.adapters.movimiento;

import com.idat.movimiento.domain.model.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {
    MovimientoMapper MAPPER = Mappers.getMapper(MovimientoMapper.class);

    Movimiento toDomain(MovimientoData entity);

    MovimientoData toEntity(Movimiento domain);
}

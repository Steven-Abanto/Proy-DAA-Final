package com.idat.cuenta.infraestructure.adapters.cuenta;

import com.idat.cuenta.domain.model.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    CuentaMapper MAPPER = Mappers.getMapper(CuentaMapper.class);

    Cuenta toDomain(CuentaData entity);

    CuentaData toEntity(Cuenta domain);
}

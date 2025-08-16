package com.idat.cuenta.infraestructure.adapters.cuenta;

import com.idat.cuenta.domain.model.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaMapper {
    CuentaMapper MAPPER = Mappers.getMapper(CuentaMapper.class);

    @Mapping(target = "uid", expression = "java(entity.getUid() == null ? null : String.valueOf(entity.getUid()))")
    Cuenta toDomain(CuentaData entity);

    @Mapping(target = "uid", ignore = true)
    CuentaData toEntity(Cuenta domain);
}

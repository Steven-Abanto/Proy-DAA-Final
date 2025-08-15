package com.instituto.matricula.infaestructure.adapters.apertura;

import com.instituto.matricula.domain.model.apertura.AperturaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


public interface AperturaDetalleMapper {
    AperturaDetalleMapper MAPPER = Mappers.getMapper(AperturaDetalleMapper.class);

    AperturaDetalle toModel(AperturaDetalleData entity);
    AperturaDetalleData toData(AperturaDetalle model);
}

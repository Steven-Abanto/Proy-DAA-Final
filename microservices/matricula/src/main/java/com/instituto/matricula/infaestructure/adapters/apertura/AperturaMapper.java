package com.instituto.matricula.infaestructure.adapters.apertura;

import com.instituto.matricula.domain.model.apertura.Apertura;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AperturaMapper {
    AperturaMapper MAPPER = Mappers.getMapper(AperturaMapper.class);

    Apertura toModel(AperturaData entity);

    AperturaData toData(Apertura model);
}

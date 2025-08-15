package com.instituto.matricula.infaestructure.adapters.profesor;

import com.instituto.matricula.domain.model.profesor.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    ProfesorMapper MAPPER = Mappers.getMapper(ProfesorMapper.class);

    Profesor toModel(ProfesorData entity);

    ProfesorData toEntity(Profesor domain);
}

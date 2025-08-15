package com.idat.profesor.infraestructure.adapter.profesor;

import com.idat.profesor.domain.model.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    ProfesorMapper MAPPER = Mappers.getMapper(ProfesorMapper.class);

    Profesor toModel(ProfesorData entity);

    ProfesorData toEntity(Profesor domain);

}

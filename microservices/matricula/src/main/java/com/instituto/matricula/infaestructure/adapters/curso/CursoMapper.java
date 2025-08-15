package com.instituto.matricula.infaestructure.adapters.curso;

import com.instituto.matricula.domain.model.curso.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoMapper MAPPER = Mappers.getMapper(CursoMapper.class);

    Curso toModel(CursoData entity);

    CursoData toData(Curso model);
}

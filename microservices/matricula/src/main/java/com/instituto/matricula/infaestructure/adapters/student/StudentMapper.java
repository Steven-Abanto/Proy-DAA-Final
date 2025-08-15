package com.instituto.matricula.infaestructure.adapters.student;

import com.instituto.matricula.domain.model.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    Student toDomain(StudentData entity);

    StudentData toEntity(Student domain);
}

package com.instituto.matricula.domain.model.student;

public interface StudentRepository {
    Student findById(String uid);
}

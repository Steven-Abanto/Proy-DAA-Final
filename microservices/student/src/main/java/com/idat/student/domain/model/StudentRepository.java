package com.idat.student.domain.model;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    Student findById(String uid);

    Student save(Student student);

    Student update(String uid, Student student);

    void delete(String uid);
}

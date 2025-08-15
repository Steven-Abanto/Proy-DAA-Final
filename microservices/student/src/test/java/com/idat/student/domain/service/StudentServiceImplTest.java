package com.idat.student.domain.service;

import com.idat.student.domain.model.Student;
import com.idat.student.domain.model.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(
                "12345678",
                "40268874",
                "Jose",
                "Pelaes",
                "9555555",
                "correo@correo.com",
                "sin",
                1
        );
    }

    @Test
    void findAll() {
        when(studentRepository.findAll())
                .thenReturn(List.of(student));
        List<Student> students = studentService.findAll();
        assertEquals(1, students.size());
    }

    @Test
    void findById() {
        when(studentRepository.findById(any(String.class)))
            .thenReturn(student);
        Student studentBuscado = studentService.findById("1");
        assertEquals(student, studentBuscado);
    }

    @Test
    void save() {
        when(studentRepository.save(any(Student.class)))
                .thenReturn(student);
        Student studentNew = new Student(
                null,
                "00403887",
                "Nelly",
                "Rosinelly",
                "9555555",
                "correo@correo.com",
                "1",
                1
        );
        Student savedStudent = studentService.save(studentNew);
        assertEquals(student, savedStudent);
    }

    @Test
    void update() {
        when(studentRepository.update(any(String.class), any(Student.class)))
                .thenReturn(student);
        Student studentUpdated = new Student(
                null,
                "00403887",
                "Nelly",
                "Rosinelly",
                "9555555",
                "correo@correo.com",
                "1",
                1
        );
        Student savedStudent = studentService.update("1", studentUpdated);
        assertEquals(student, savedStudent);
    }
}
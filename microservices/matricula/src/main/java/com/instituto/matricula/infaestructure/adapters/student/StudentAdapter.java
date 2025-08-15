package com.instituto.matricula.infaestructure.adapters.student;

import com.instituto.matricula.domain.model.student.Student;
import com.instituto.matricula.domain.model.student.StudentRepository;
import org.springframework.web.client.RestTemplate;

public class StudentAdapter implements StudentRepository {

    private final RestTemplate restTemplate;

    public StudentAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Student findById(String uid) {
        String url = "http://localhost:8081/api/v1/instituto/student/" + uid;
        StudentData studentData = restTemplate.getForObject(url, StudentData.class);
        return StudentMapper.MAPPER.toDomain(studentData);
    }
}

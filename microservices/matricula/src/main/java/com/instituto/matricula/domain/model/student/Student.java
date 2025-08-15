package com.instituto.matricula.domain.model.student;

public record Student(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        String photo,
        int active
) {
}

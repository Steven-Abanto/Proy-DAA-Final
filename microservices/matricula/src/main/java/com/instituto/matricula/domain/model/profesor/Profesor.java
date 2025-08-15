package com.instituto.matricula.domain.model.profesor;

public record Profesor(
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

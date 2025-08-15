package com.idat.profesor.domain.model;

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

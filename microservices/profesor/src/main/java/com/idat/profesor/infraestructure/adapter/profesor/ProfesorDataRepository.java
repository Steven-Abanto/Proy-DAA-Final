package com.idat.profesor.infraestructure.adapter.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorDataRepository extends JpaRepository<ProfesorData, String> {
}

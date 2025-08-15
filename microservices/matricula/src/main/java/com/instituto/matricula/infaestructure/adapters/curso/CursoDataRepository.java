package com.instituto.matricula.infaestructure.adapters.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDataRepository extends JpaRepository<CursoData, String> {
}

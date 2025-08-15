package com.instituto.matricula.infaestructure.adapters.apertura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AperturaDataRepository extends JpaRepository<AperturaData, String> {
}

package com.instituto.matricula.infaestructure.adapters.apertura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AperturaDetalleDataRepository extends JpaRepository<AperturaDetalleData, Long> {
    List<AperturaDetalleData> findByUidApertura(String uidApertura);
    List<AperturaDetalleData> findByUidAlumno(String uidAlumno);

}

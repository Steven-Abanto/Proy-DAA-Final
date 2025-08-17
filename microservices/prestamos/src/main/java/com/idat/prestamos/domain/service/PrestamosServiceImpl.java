package com.idat.prestamos.domain.service;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.PrestamoDetalleRepository;
import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.model.PrestamosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosServiceImpl implements PrestamosService {

    private final PrestamosRepository prestamosRepository;
    private final PrestamoDetalleService prestamoDetalleService;

    public PrestamosServiceImpl(PrestamosRepository prestamosRepository, PrestamoDetalleService prestamoDetalleService) {
        this.prestamosRepository = prestamosRepository;
        this.prestamoDetalleService = prestamoDetalleService;
    }

    @Override
    public List<Prestamos> findAll() {
        return prestamosRepository.findAll();
    }

    @Override
    public Prestamos findById(int uid) {
        return prestamosRepository.findById(uid);
    }

    @Override
    public Prestamos save(Prestamos prestamos) {
        return prestamosRepository.save(prestamos);
    }


    @Override
    @Transactional
    public Prestamos crearPrestamoConDetalle(Prestamos prestamo, List<PrestamoDetalle> detalles) {
        // 1. Guardar el préstamo principal
        Prestamos prestamoGuardado = prestamosRepository.save(prestamo);

        // 2. Asignar el uid del préstamo y el monto principal a cada detalle
        for (PrestamoDetalle detalle : detalles) {
            PrestamoDetalle detalleConUid = new PrestamoDetalle(
                    0, // uid del detalle
                    prestamoGuardado.uid(),            // uid del préstamo
                    detalle.uidCuenta(),
                    prestamoGuardado.monto(),          // ← monto del préstamo principal
                    detalle.tasaInt(),
                    detalle.cuotas(),
                    detalle.deuda_cuota(),
                    detalle.deuda_total(),
                    detalle.fecha()
            );
            System.out.println("Monto en detalle: " + detalleConUid.montoPrestamo());

            prestamoDetalleService.save(detalleConUid);
        }

        // 3. Retornar el préstamo guardado
        return prestamoGuardado;
    }


    @Override
    public Prestamos update(int uid, Prestamos prestamos) {
        return prestamosRepository.update(uid, prestamos);
    }

    @Override
    public void delete(int uid) {
        prestamosRepository.delete(uid);
    }


}

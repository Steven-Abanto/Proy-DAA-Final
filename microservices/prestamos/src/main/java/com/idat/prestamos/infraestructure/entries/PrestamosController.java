package com.idat.prestamos.infraestructure.entries;

import com.idat.prestamos.domain.model.PrestamoDetalle;
import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.service.PrestamoDetalleService;
import com.idat.prestamos.domain.service.PrestamosService;
import com.idat.prestamos.infraestructure.adapters.prestamos.PrestamoDetalleMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bank/loans")
public class PrestamosController {

    private final PrestamosService prestamosService;
    private final PrestamoDetalleService prestamoDetalleService;

    public PrestamosController(PrestamosService prestamosService, PrestamoDetalleService prestamoDetalleService) {
        this.prestamosService = prestamosService;
        this.prestamoDetalleService = prestamoDetalleService;
    }

    // Listar todos los préstamos
    @GetMapping
    public ResponseEntity<List<Prestamos>> listarTodos() {
        return ResponseEntity.ok(prestamosService.findAll());
    }

    // Buscar un préstamo por id
    @GetMapping("/{id}")
    public ResponseEntity<Prestamos> buscarPorId(@PathVariable int id) {
        Prestamos prestamo = prestamosService.findById(id);
        return ResponseEntity.ok(prestamo);
    }


    //Buscar detalle de prestamo por id
    @GetMapping("/detalles/{uid}")
    public ResponseEntity<PrestamoDetalle> detallePrestamoPorId(@PathVariable("uid") int uid){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(prestamoDetalleService.findById(uid));
    }


    // Crear préstamo con detalle
    @PostMapping
    public ResponseEntity<Prestamos> crearPrestamo(@RequestBody Prestamos prestamo) {
        Prestamos nuevo = prestamosService.save(prestamo);
        return ResponseEntity.ok(nuevo);
    }

    @PostMapping("/con-detalles")
    public ResponseEntity<Prestamos> crearPrestamoConDetalles(@RequestBody PrestamoConDetalles request) {
        Prestamos creado = prestamosService.crearPrestamoConDetalle(request.getPrestamo(), request.getDetalles());
        return ResponseEntity.ok(creado);
    }

    // Actualizar préstamo
    @PutMapping("/{id}")
    public ResponseEntity<Prestamos> actualizarPrestamo(@PathVariable int id, @RequestBody Prestamos prestamo) {
        Prestamos actualizado = prestamosService.update(id, prestamo);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar préstamo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable int id) {
        prestamosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

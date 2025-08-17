package com.idat.prestamos.infraestructure.entries;

import com.idat.prestamos.domain.model.Prestamos;
import com.idat.prestamos.domain.service.PrestamosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank/loans")
public class PrestamosController {

    private final PrestamosService prestamosService;

    public PrestamosController(PrestamosService prestamosService) {
        this.prestamosService = prestamosService;
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

    // Crear préstamo con detalle
    @PostMapping
    public ResponseEntity<Prestamos> crearPrestamo(@RequestBody Prestamos prestamo) {
        Prestamos nuevo = prestamosService.save(prestamo);
        return ResponseEntity.ok(nuevo);
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

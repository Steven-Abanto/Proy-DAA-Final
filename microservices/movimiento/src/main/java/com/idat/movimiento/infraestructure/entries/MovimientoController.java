package com.idat.movimiento.infraestructure.entries;

import com.idat.movimiento.domain.model.Movimiento;
import com.idat.movimiento.domain.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bank/movements")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.findAll();
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable("uid") int uid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movimientoService.findById(uid));
    }

    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(movimientoService.save(movimiento));
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable("uid") int uid, @RequestBody Movimiento movimiento) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(movimientoService.update(uid, movimiento));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteMovimientoById(@PathVariable("uid") int uid) {
        movimientoService.delete(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

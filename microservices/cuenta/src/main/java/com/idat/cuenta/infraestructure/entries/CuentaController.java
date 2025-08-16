package com.idat.cuenta.infraestructure.entries;

import com.idat.cuenta.domain.model.Cuenta;
import com.idat.cuenta.domain.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banco/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.findAll();
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable("numeroCuenta") String numeroCuenta) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cuentaService.findById(numeroCuenta));
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(cuentaService.save(cuenta));
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable("numeroCuenta") String numeroCuenta, @RequestBody Cuenta cuenta) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(cuentaService.update(numeroCuenta, cuenta));
    }

    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable("numeroCuenta") String numeroCuenta) {
        cuentaService.delete(numeroCuenta);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

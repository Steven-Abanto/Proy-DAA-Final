package com.instituto.matricula.infaestructure.entries.apertura;

import com.instituto.matricula.domain.model.apertura.Apertura;
import com.instituto.matricula.domain.service.apertura.AperturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instituto/matricula/apertura/")
public class AperturaController {

    private final AperturaService aperturaService;

    public AperturaController(AperturaService aperturaService) {
        this.aperturaService = aperturaService;
    }

    @GetMapping
    public ResponseEntity<List<Apertura>> findAll() {
        return ResponseEntity.ok(aperturaService.findAll());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Apertura> findById(String uid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(aperturaService.findById(uid));
    }

    @PostMapping
    public ResponseEntity<Apertura> save(@RequestBody Apertura apertura) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(aperturaService.save(apertura));
    }

}

package com.idat.profesor.infraestructure.entries;

import com.idat.profesor.domain.model.Profesor;
import com.idat.profesor.domain.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instituto/profesor/")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    ResponseEntity<List<Profesor>> findAll() {
        return ResponseEntity.ok(profesorService.findAll());
    }

    @GetMapping("/{uid}")
    ResponseEntity<Profesor> findByUid(@PathVariable("uid") String uid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profesorService.findById(uid));
    }

    @PostMapping
    ResponseEntity<Profesor> create(@RequestBody Profesor profesor) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(profesorService.save(profesor));
    }

    @PutMapping("/{uid}")
    ResponseEntity<Profesor>  update(@PathVariable("uid") String uid, @RequestBody Profesor profesor) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(profesorService.update(uid, profesor));
    }

    @DeleteMapping("/{uid}")
    ResponseEntity<Void>  delete(@PathVariable("uid") String uid) {
        profesorService.delete(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

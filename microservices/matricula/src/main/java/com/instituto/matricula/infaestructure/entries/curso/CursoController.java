package com.instituto.matricula.infaestructure.entries.curso;

import com.instituto.matricula.domain.model.curso.Curso;
import com.instituto.matricula.domain.service.curso.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instituto/matricula/curso/")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Curso> findByUid(@PathVariable("uid") String uid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.findById(uid));
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(cursoService.save(curso));
    }
}

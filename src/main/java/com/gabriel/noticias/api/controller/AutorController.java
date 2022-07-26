package com.gabriel.noticias.api.controller;

import com.gabriel.noticias.api.assembler.AutorAssembler;
import com.gabriel.noticias.api.model.AutorModel;
import com.gabriel.noticias.api.model.AutorUpdateModel;
import com.gabriel.noticias.api.model.request.AutorRequest;
import com.gabriel.noticias.domain.model.Autor;
import com.gabriel.noticias.domain.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("autores")
public class AutorController {

    private AutorService service;
    private AutorAssembler assembler;

    @GetMapping
    public ResponseEntity<List<AutorModel>> buscarTodos() {
        return ResponseEntity.ok(assembler.toCollectionModel(service.buscarTodos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(assembler.toModel(service.buscarPorId(id)));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AutorModel> salvarAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = assembler.toEntity(autorRequest);
        autor.setDataCriacao(OffsetDateTime.now());
        return ResponseEntity.ok(assembler.toModel(service.salvarAutor(autor)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorUpdateModel> editarAutor(@PathVariable Long id, @Valid @RequestBody AutorRequest autorRequest) {
        Autor autorAux = service.buscarPorId(id);
        Autor autor = assembler.toEntity(autorRequest);
        autor.setDataCriacao(autorAux.getDataCriacao());
        autor.setId(id);
        return ResponseEntity.ok(assembler.toUpdateModel(service.salvarAutor(autor)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAutor(@PathVariable Long id) {
        Autor autor = service.buscarPorId(id);
        service.removerAutor(autor);
        return ResponseEntity.noContent().build();
    }






















}

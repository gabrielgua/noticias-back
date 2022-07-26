package com.gabriel.noticias.api.controller;

import com.gabriel.noticias.api.assembler.NoticiaAssembler;
import com.gabriel.noticias.api.model.NoticiaModel;
import com.gabriel.noticias.api.model.request.NoticiaRequest;
import com.gabriel.noticias.domain.model.Noticia;
import com.gabriel.noticias.domain.service.NoticiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("noticias")
public class NoticiaController {

    private NoticiaService service;
    private NoticiaAssembler assembler;

    @GetMapping
    public ResponseEntity<List<NoticiaModel>> listarNoticias() {
        return ResponseEntity.ok(assembler.toCollectionModel(service.buscarTodos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticiaModel> buscarNoticiaPorId(@PathVariable Long id) {
        Noticia noticia = service.buscarPorId(id);
        return ResponseEntity.ok(assembler.toModel(noticia));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoticiaModel salvarNoticia(@Valid @RequestBody NoticiaRequest noticiaRequest) {
        Noticia noticia = assembler.toEntity(noticiaRequest);
        Noticia novaNoticia = service.salvarNoticia(noticia);
        return assembler.toModel(service.salvarNoticia(novaNoticia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticiaModel> editarNoticia(@PathVariable Long id, @Valid @RequestBody NoticiaRequest noticiaRequest) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        Noticia noticia = assembler.toEntity(noticiaRequest);
        noticia.setId(id);
        noticia = service.salvarNoticia(noticia);
        return ResponseEntity.ok(assembler.toModel(noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerNoticia(@PathVariable Long id) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        service.removerNoticia(id);
        return ResponseEntity.noContent().build();
    }





























}

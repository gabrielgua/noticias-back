package com.gabriel.noticias.api.controller;

import com.gabriel.noticias.api.assembler.LeitorAssembler;
import com.gabriel.noticias.api.model.LeitorModel;
import com.gabriel.noticias.api.model.LeitorUpdateModel;
import com.gabriel.noticias.api.model.request.LeitorRequest;
import com.gabriel.noticias.domain.model.Leitor;
import com.gabriel.noticias.domain.model.Noticia;
import com.gabriel.noticias.domain.service.LeitorService;
import com.gabriel.noticias.domain.service.NoticiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("leitores")
@AllArgsConstructor
public class LeitorController {

    private LeitorService service;

    private LeitorAssembler assembler;
    private NoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<List<LeitorModel>> buscarTodos() {
        return ResponseEntity.ok(assembler.toCollectionModel(service.buscarTodos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeitorModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(assembler.toModel(service.buscarPorId(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LeitorModel> salvarLeitor(@Valid @RequestBody LeitorRequest leitorRequest) {
        Leitor leitor = assembler.toEntity(leitorRequest);
        leitor.setDataCriacao(OffsetDateTime.now());
        return ResponseEntity.ok(assembler.toModel(service.salvarLeitor(leitor)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeitorUpdateModel> editarLeitor(@Valid @RequestBody LeitorRequest leitorRequest, @PathVariable Long id) {
        Leitor leitorAux = service.buscarPorId(id);
        Leitor leitor = assembler.toEntity(leitorRequest);
        leitor.setDataCriacao(leitorAux.getDataCriacao());
        leitor.setId(leitorAux.getId());
        return ResponseEntity.ok(assembler.toUpdateModel(service.salvarLeitor(leitor)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLeitor(@PathVariable Long id) {
        Leitor leitor = service.buscarPorId(id);
        service.removerLeitor(leitor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{leitorId}/favoritar/{noticiaId}")
    public ResponseEntity<LeitorModel> adicionarNoticiaAosFavoritos(@PathVariable Long leitorId, @PathVariable Long noticiaId) {
        Leitor leitor = service.buscarPorId(leitorId);
        Noticia noticia = noticiaService.buscarPorId(noticiaId);
        leitor.adicionarNoticia(noticia);

        noticia.adicionarLike(leitor);
        noticiaService.salvarNoticia(noticia);
        return ResponseEntity.ok(assembler.toModel(service.salvarLeitor(leitor)));
    }

    @DeleteMapping("/{leitorId}/favoritar/{noticiaId}")
    public ResponseEntity<LeitorModel> removerNoticiaDosFavoritos(@PathVariable Long leitorId, @PathVariable Long noticiaId) {
        Leitor leitor = service.buscarPorId(leitorId);
        Noticia noticia = noticiaService.buscarPorId(noticiaId);
        leitor.removerNoticia(noticia);
        service.salvarLeitor(leitor);

        noticia.removerLike(leitor);
        noticiaService.salvarNoticia(noticia);
        return ResponseEntity.noContent().build();
    }
























}

package com.gabriel.noticias.api.model;

import com.gabriel.noticias.domain.model.Autor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class NoticiaModel {

    private Long id;
    private String titulo;
    private String conteudo;
    private AutorModelResumo autor;
    private OffsetDateTime dataCriacao;
}

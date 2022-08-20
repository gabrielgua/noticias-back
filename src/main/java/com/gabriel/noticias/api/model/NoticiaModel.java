package com.gabriel.noticias.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class NoticiaModel {

    private Long id;
    private AutorModelResumo autor;
    private String titulo;
    private String conteudo;
    private Integer likes;
    private OffsetDateTime dataCriacao;
}

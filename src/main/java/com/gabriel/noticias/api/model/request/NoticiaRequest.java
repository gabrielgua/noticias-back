package com.gabriel.noticias.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NoticiaRequest {

    @Valid
    @NotNull
    private AutorRequestId autor;

    @NotBlank
    private String titulo;

    @NotBlank
    private String conteudo;
}

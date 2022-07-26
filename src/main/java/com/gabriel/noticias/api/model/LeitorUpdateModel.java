package com.gabriel.noticias.api.model;

import com.gabriel.noticias.domain.model.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class LeitorUpdateModel {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private OffsetDateTime dataCriacao;
    private Perfil perfil;
}

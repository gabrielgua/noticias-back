package com.gabriel.noticias.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {
    LEITOR(0, "ROLE_LEITOR"), AUTOR(1, "ROLE_AUTOR"), ADMIN(2, "ROLE_ADMIN");

    private Integer cod;
    private String descricao;
}

package com.gabriel.noticias.api.model;

import com.gabriel.noticias.domain.model.Noticia;
import com.gabriel.noticias.domain.model.enums.Perfil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class LeitorModel {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private OffsetDateTime dataCriacao;
    private Perfil perfil;
    private List<NoticiaModel> likedNoticias;

}

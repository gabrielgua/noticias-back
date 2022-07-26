package com.gabriel.noticias.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String titulo;
    private String conteudo;
    private OffsetDateTime dataCriacao;

    @ManyToOne
    private Autor autor;

    @ManyToMany(mappedBy = "likedNoticias")
    private Set<Leitor> likes;

    public void adicionarLike(Leitor leitor) {
        likes.add(leitor);
    }

    public void removerLike(Leitor leitor) {
        likes.remove(leitor);
    }
}

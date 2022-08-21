package com.gabriel.noticias.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
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
    private Set<Leitor> leitoresWhoLiked = new HashSet<Leitor>();

    private Integer likes;

    public void adicionarLike(Leitor leitor) {
        leitoresWhoLiked.add(leitor);
        setLikes(leitoresWhoLiked.size());
    }

    public void removerLike(Leitor leitor) {
        leitoresWhoLiked.remove(leitor);
        setLikes(leitoresWhoLiked.size());
    }
}

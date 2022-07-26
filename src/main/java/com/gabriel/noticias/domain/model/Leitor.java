package com.gabriel.noticias.domain.model;


import com.gabriel.noticias.domain.model.enums.Perfil;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Leitor extends Usuario{

    @ManyToMany
    @JoinTable(
            name = "leitor_noticias",
            joinColumns = @JoinColumn(name = "leitor_id"),
            inverseJoinColumns = @JoinColumn(name = "noticia_id")
    )
    private Set<Noticia> likedNoticias;

    public Leitor() {
        super();
        setPerfil(Perfil.LEITOR);
    }

    public void adicionarNoticia(Noticia noticia) {
        likedNoticias.add(noticia);
    }

    public void removerNoticia(Noticia noticia) {
        likedNoticias.remove(noticia);
    }
}



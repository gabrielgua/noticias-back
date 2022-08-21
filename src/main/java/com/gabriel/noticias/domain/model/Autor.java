package com.gabriel.noticias.domain.model;

import com.gabriel.noticias.domain.model.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Entity
public class Autor extends Usuario{

    @OneToMany(mappedBy = "autor")
    private Set<Noticia> noticias;

    public Autor() {
        super();
        setPerfil(Perfil.AUTOR);
    }
}

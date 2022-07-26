package com.gabriel.noticias.domain.service;


import com.gabriel.noticias.api.exception.ObjectNotFoundException;
import com.gabriel.noticias.domain.model.Autor;
import com.gabriel.noticias.domain.model.Noticia;
import com.gabriel.noticias.domain.repository.NoticiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoticiaService {

    private NoticiaRepository repository;
    private AutorService autorService;

    @Transactional(readOnly = true)
    public List<Noticia> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Noticia buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Noticia não encontrada, id: " + id));
    }

    public Noticia salvarNoticia(Noticia noticia) {
        Autor autor = autorService.buscarPorId(noticia.getAutor().getId());

        noticia.setAutor(autor);
        noticia.setDataCriacao(OffsetDateTime.now());
        return repository.save(noticia);
    }

    public void removerNoticia(Long id) {
        repository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }
}

package com.gabriel.noticias.domain.service;

import com.gabriel.noticias.api.exception.DataIntegrityViolationException;
import com.gabriel.noticias.api.exception.ObjectNotFoundException;
import com.gabriel.noticias.domain.model.Autor;
import com.gabriel.noticias.domain.model.Usuario;
import com.gabriel.noticias.domain.repository.AutorRepository;
import com.gabriel.noticias.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutorService {

    private AutorRepository repository;
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Autor> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Autor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado, id: " + id));
    }

    @Transactional
    public Autor salvarAutor(Autor autor) {
        validaEmailECpf(autor);
        return repository.save(autor);
    }

    @Transactional
    public void removerAutor(Autor autor) {
        if (!autor.getNoticias().isEmpty()) {
            throw new DataIntegrityViolationException("Autor possui notícias atreladas.");
        }
        repository.delete(autor);
    }

    public void validaEmailECpf(Autor autor) {

        Optional<Usuario> usuario = usuarioRepository.findByCpf(autor.getCpf());
        if (usuario.isPresent() && usuario.get().getId() != autor.getId()) {
            System.out.println(usuario.get().getId() + ", " + autor.getId());
            throw new DataIntegrityViolationException("CPF já cadastrado!");
        }

        usuario = usuarioRepository.findByEmail(autor.getEmail());
        if (usuario.isPresent() && usuario.get().getId() != autor.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado!");
        }
    }
}

package com.gabriel.noticias.domain.service;

import com.gabriel.noticias.api.exception.DataIntegrityViolationException;
import com.gabriel.noticias.api.exception.ObjectNotFoundException;
import com.gabriel.noticias.domain.model.Leitor;
import com.gabriel.noticias.domain.model.Usuario;
import com.gabriel.noticias.domain.repository.LeitorRepository;
import com.gabriel.noticias.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LeitorService {

    private LeitorRepository repository;
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Leitor> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Leitor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Leitor não encontrado, id: " + id));
    }

    @Transactional
    public Leitor salvarLeitor(Leitor leitor) {
        //leitor.setSenha(enconder.econde(leitor.getSenha()));
        validaEmailECpf(leitor);
        return repository.save(leitor);
    }

    @Transactional
    public void removerLeitor(Leitor leitor) {
        repository.delete(leitor);
    }


    public void validaEmailECpf(Leitor leitor) {

        Optional<Usuario> usuario = usuarioRepository.findByCpf(leitor.getCpf());
        if (usuario.isPresent() && usuario.get().getId() != leitor.getId()) {
            System.out.println(usuario.get().getId() + ", " + leitor.getId());
            throw new DataIntegrityViolationException("CPF já cadastrado!");
        }

        usuario = usuarioRepository.findByEmail(leitor.getEmail());
        if (usuario.isPresent() && usuario.get().getId() != leitor.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado!");
        }
    }


}

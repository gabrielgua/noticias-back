package com.gabriel.noticias.domain.repository;

import com.gabriel.noticias.domain.model.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}

package br.edu.univille.extensao.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.extensao.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Page<Evento> findByDestaqueTrue(Pageable pageable);
    Page<Evento> findByOrderByDataTerminoDesc(Pageable pageable);
    Page<Evento> findByEnderecoContainingAndCategoriaContainingAndData(
        String endereco, String categoria, LocalDate dataTermino, Pageable pageable
    );
}

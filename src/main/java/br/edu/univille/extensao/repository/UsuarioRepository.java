package br.edu.univille.extensao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.extensao.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

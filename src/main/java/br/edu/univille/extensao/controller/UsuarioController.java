package br.edu.univille.extensao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.extensao.dto.UsuarioUpdateDTO;
import br.edu.univille.extensao.entity.Usuario;
import br.edu.univille.extensao.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setUsername(dto.getUsername());
        usuario.setSenha(dto.getSenha());
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @GetMapping("/home")
    public Usuario home() {
        // Implemente lógica para buscar eventos criados e que participa
        return new Usuario();
    }
}

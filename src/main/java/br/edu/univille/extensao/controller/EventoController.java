package br.edu.univille.extensao.controller;

import br.edu.univille.extensao.entity.Evento;
import br.edu.univille.extensao.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/destaques")
    public Page<Evento> destaques(Pageable pageable) {
        return eventoRepository.findByDestaqueTrue(pageable);
    }

    @GetMapping("/recentes")
    public Page<Evento> recentes(Pageable pageable) {
        return eventoRepository.findByOrderByDataTerminoDesc(pageable);
    }

    @GetMapping
    public Page<Evento> filtrar(
        @RequestParam(required = false, defaultValue = "") String endereco,
        @RequestParam(required = false, defaultValue = "") String categoria,
        @RequestParam(required = false) LocalDate dataTermino,
        Pageable pageable
    ) {
        return eventoRepository.findByEnderecoContainingAndCategoriaContainingAndData(
            endereco, categoria, dataTermino, pageable
        );
    }

    @GetMapping("/{id}")
    public Optional<Evento> getEvento(@PathVariable Long id) {
        return eventoRepository.findById(id);
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        // Validações aqui
        return eventoRepository.save(evento);
    }

    @PutMapping("/{id}")
    public Evento editarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return eventoRepository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }

    @GetMapping("/calendario/usuario/{id}")
    public Page<Evento> calendarioUsuario(@PathVariable Long id, Pageable pageable) {
        // Implemente busca por eventos do usuário
        return Page.empty();
    }

    @GetMapping("/calendario/empresa/{id}")
    public Page<Evento> calendarioEmpresa(@PathVariable Long id, Pageable pageable) {
        // Implemente busca por eventos da empresa
        return Page.empty();
    }
}

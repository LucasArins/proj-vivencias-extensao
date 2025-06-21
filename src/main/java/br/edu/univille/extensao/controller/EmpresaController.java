package br.edu.univille.extensao.controller;

import br.edu.univille.extensao.entity.Empresa;
import br.edu.univille.extensao.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable Long id) {
        return empresaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable Long id) {
        empresaRepository.deleteById(id);
    }

    @GetMapping("/home")
    public Empresa home() {
        // Implemente lógica para buscar eventos da empresa, convites, etc
        return new Empresa();
    }
}

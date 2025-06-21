package br.edu.univille.extensao.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cnpj;
    private String endereco;
    private String senha;

    @OneToMany(mappedBy = "empresa")
    private List<Evento> eventos;
}
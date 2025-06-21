package br.edu.univille.extensao.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String duracao;
    private int capacidade;
    private boolean acesso;
    private String endereco;
    private String categoria;
    private LocalDate datainicio;
    private LocalDate datatermino;
    private boolean destaque;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToMany(mappedBy = "eventosParticipando")
    private List<Usuario> participantes;
}
package br.edu.univille.extensao.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EventoDTO {
    private String nome;
    private String duracao;
    private int capacidade;
    private boolean acesso;
    private String endereco;
    private String categoria;
    private LocalDate datainicio;
    private LocalDate datatermino;
    private boolean destaque;
}
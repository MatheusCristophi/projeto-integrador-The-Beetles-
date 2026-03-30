package com.Beetles.SystemPayout.backEnd.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "planos")
public class Planos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer planoId;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private Integer frequenciaSemanal;
    private BigDecimal valor;
    private boolean ativo;
    private LocalDate dataCriacao; //1

    public Integer getPlanoId() {
        return planoId;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void onCreated() {
        this.dataCriacao = LocalDate.now();
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public void setCategoria(@NonNull String categoria) {
        this.categoria = categoria;
    }

    public void setFrequenciaSemanal(int frequencia_semanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }

    public void setValor(@NonNull BigDecimal valor) {
        this.valor = valor;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

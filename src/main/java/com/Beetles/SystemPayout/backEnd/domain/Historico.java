package com.Beetles.SystemPayout.backEnd.domain;

import jakarta.persistence.*;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_pagamento")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer historicoId;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private User historicoAlunoId;
    private BigDecimal valorCobrado;
    private String statusPagamento;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataConfirmacao;

    public @NonNull Integer getHistoricoId() {
        return historicoId;
    }

    public User getHistoricoAlunoId() {
        return historicoAlunoId;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public LocalDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public void setHistoricoAlunoId(User historicoAlunoId) {
        this.historicoAlunoId = historicoAlunoId;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
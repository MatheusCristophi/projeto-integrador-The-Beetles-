package com.Beetles.systempayout.backend.historico.model;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "historico_pagamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)

    private Integer historicoId;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno historicoAlunoId;
    @Column(precision = 10, scale = 2)
    private BigDecimal valorCobrado;
    private String statusPagamento;
    private LocalDate dataSolicitacao;
    private LocalDate dataConfirmacao;

    public void solicitacao() {
        if (this.historicoAlunoId != null) {
            this.dataSolicitacao = LocalDate.now();
        }
    }
}
package com.Beetles.systempayout.backend.plano.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "planos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer frequenciaAulas;
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
    private boolean ativo;
    @Column(updatable = false)
    private LocalDate dataCriacao;
}

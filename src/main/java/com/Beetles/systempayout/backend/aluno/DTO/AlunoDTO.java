package com.Beetles.systempayout.backend.aluno.DTO;

import com.Beetles.systempayout.backend.plano.model.Planos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlunoDTO {
   private Integer alunoId;
    private String telefone;
    private String nome;
    private Planos planoEscolhidoId;
    private boolean primeiroAcesso;
    private String status;
    private LocalDate diaVencimento;
    private LocalDate dataProximoVencimento;
    private LocalDate dataInicioPlano;
    private LocalDate dataCadastro;
}

package com.Beetles.SystemPayout.backEnd.domain;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;




/*
Classe de criação de usuários normal, aqui é onde está a os atributos do usuário
*/

@Entity  //Essa anotação faz o SpringBoot reconhecer a Classe com uma entidade
@Table(name="alunos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "telefone")
}) //Essa anotação ja cria uma tabela no banco de dados com o nome indicado, E o UniqueConstrains torna um atributo Unico(não pode ter um igual)
public class User {
    /*
    Essa abaixo é uma geração automatica do Id do usuário
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id",nullable = false, unique = true)//Não permite o atributo ser null
    private Integer alunoId;
    @Column(unique = true, nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Planos planoEscolhido;
    private boolean primeiroAcesso;
    private String status;
    private LocalDate diaVencimento;
    private LocalDate dataProximoVencimento;
    private LocalDate dataCadastro;

    public User() {
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public String getNome() {
        return nome;
    }

    public Planos getPlanoescolhidoId() {
        return planoEscolhido;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDiaVencimento() {
        return diaVencimento;
    }

    public LocalDate getDataProximoVencimento() {
        return dataProximoVencimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void onCreated(){
        this.dataCadastro = LocalDate.now();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlanoEscolhido(Planos planoEscolhido) {
        this.planoEscolhido = planoEscolhido;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public void transformarTelefone() {
        this.telefone = this.telefone + "@ctjsfightuba.com.br";
    }
}

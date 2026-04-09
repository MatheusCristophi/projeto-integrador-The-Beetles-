package com.Beetles.systempayout.backend.aluno.service;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import com.Beetles.systempayout.backend.aluno.repository.AlunoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Essa anotação faz o SpringBoot reconhecer essa classe como um service
@org.springframework.stereotype.Service

public class AlunoService {
    // Isso é uma injeção de dependencia, estou injetando o Repositorio para ser usado nessa classe
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Aqui estou criando um metodo para ver todos os usuários do sistema

    public List<Aluno> showUsers() {
        return repository.findAll();
    }

    // Já esse metodo é para ver um usuário pelo Id dele

    public Aluno showUserById(/* Aqui é onde colocamos os parametros do metodo */ Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not exist"));
    }

    // Esse é para criar um novo usuário no sistema

    @Transactional
    public Aluno saveUser(Aluno aluno) {
        return repository.save(aluno);
    }

    // Esse é para deletar um usuário do sistema pelo Id

    @Transactional
    public void deleteUserById(Integer id) {
        if (!repository.existsById(id)) {
        throw new RuntimeException("Não foi possível deletar o Usuário: Id invalido");
        }
        repository.deleteById(id);
}
    // Esse é para atualizar os dados do usuário

    @Transactional
    public Aluno updateUser(Integer id, Aluno aluno){
        Aluno alunoExist = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id Not Exist"));
            if(aluno.getNome() != null){
            alunoExist.setNome(aluno.getNome());}
            if (aluno.getTelefone() != null){
            alunoExist.setTelefone(aluno.getTelefone());}
            if (aluno.getStatus() != null){
            alunoExist.setStatus(aluno.getStatus());}
            if (aluno.getPlanoEscolhidoId() != null){
            alunoExist.setPlanoEscolhidoId(aluno.getPlanoEscolhidoId());}
            return repository.save(alunoExist);
    }
}

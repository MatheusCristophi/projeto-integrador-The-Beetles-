package com.Beetles.SystemPayout.backEnd.service;

import com.Beetles.SystemPayout.backEnd.domain.User;
import com.Beetles.SystemPayout.backEnd.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Essa anotação faz o SpringBoot reconhecer essa classe como um service
@org.springframework.stereotype.Service

public class UserService {
    // Isso é uma injeção de dependencia, estou injetando o Repositorio para ser usado nessa classe
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Aqui estou criando um metodo para ver todos os usuários do sistema

    public List<User> showUsers() {
        return repository.findAll();
    }

    // Já esse metodo é para ver um usuário pelo Id dele

    public User showUserById(/* Aqui é onde colocamos os parametros do metodo */ Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not exist"));
    }

    // Esse é para criar um novo usuário no sistema

    public User saveUser(User user) {
        return repository.save(user);
    }

    // Esse é para deletar um usuário do sistema pelo Id

    public void deleteUserById(Integer id) {
        if (!repository.existsById(id)) {
        throw new RuntimeException("Não foi possível deletar o Usuário: Id invalido");
        }
        repository.deleteById(id);
}
    // Esse é para atualizar os dados do usuário

    public User updateUser(Integer id, User user){
        User userExist = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id Not Exist"));
            if(userExist.getNome() != null){
            userExist.setNome(user.getNome());}
            if (userExist.getTelefone() != null){
            userExist.setTelefone(user.getTelefone());}
            if (userExist.getStatus() != null){
            userExist.setStatus(user.getStatus());}
            if (userExist.getPlanoescolhidoId() != null){
            userExist.setPlanoEscolhido(user.getPlanoescolhidoId());}
            return repository.save(userExist);
    }
}

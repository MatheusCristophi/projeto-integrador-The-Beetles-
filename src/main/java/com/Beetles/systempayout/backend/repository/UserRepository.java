package com.Beetles.systempayout.backend.repository;

import com.Beetles.systempayout.backend.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Essa anotação faz o SpringBoot reconhecer essa Interface como um repositório
*/

@org.springframework.stereotype.Repository


//Aqui estou extendo o JPA que realiza a conexão com o banco de dados
public interface UserRepository extends JpaRepository<Aluno, Integer> {
}

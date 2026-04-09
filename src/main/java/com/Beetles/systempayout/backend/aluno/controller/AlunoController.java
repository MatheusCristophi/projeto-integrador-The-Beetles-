package com.Beetles.systempayout.backend.aluno.controller;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import com.Beetles.systempayout.backend.aluno.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/save")
    public ResponseEntity<Aluno> saveUsers(@RequestBody Aluno aluno){
            Aluno savedAluno = alunoService.saveUser(aluno);
            return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Aluno>> showAllUsers(){
            List<Aluno> aluno = alunoService.showUsers();
            return ResponseEntity.ok(aluno);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Aluno> showIdUser(@PathVariable Integer id){
            Aluno aluno = alunoService.showUserById(id);
            return ResponseEntity.ok(aluno);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aluno> updateUser(@PathVariable Integer id, @RequestBody Aluno aluno){
            Aluno alunoUp = alunoService.updateUser(id, aluno);
            return new ResponseEntity<>(alunoUp, HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
            alunoService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}

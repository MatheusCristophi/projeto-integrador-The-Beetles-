package com.Beetles.systempayout.backend.controller;

import com.Beetles.systempayout.backend.domain.Aluno;
import com.Beetles.systempayout.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<Aluno> saveUsers(@RequestBody Aluno aluno){
            Aluno savedAluno = userService.saveUser(aluno);
            return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Aluno>> showAllUsers(){
            List<Aluno> aluno = userService.showUsers();
            return ResponseEntity.ok(aluno);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Aluno> showIdUser(@PathVariable Integer id){
            Aluno aluno = userService.showUserById(id);
            return ResponseEntity.ok(aluno);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aluno> updateUser(@PathVariable Integer id, @RequestBody Aluno aluno){
            Aluno alunoUp = userService.updateUser(id, aluno);
            return new ResponseEntity<>(alunoUp, HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}

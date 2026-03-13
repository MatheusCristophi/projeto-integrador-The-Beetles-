package com.Beetles.SystemPayout.controller;

import com.Beetles.SystemPayout.entity.User;
import com.Beetles.SystemPayout.exceptions.ShowUserError;
import com.Beetles.SystemPayout.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/users")

public class Controller {
    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> showAllUsers(){
        try{
            List<User> user = service.showUsers();
            return ResponseEntity.ok(user);
    } catch (ShowUserError e) {
            throw new ShowUserError(e.getMessage());
        }
    }

    @GetMapping("/getuserid")
    public ResponseEntity<User> showIdUser(@PathVariable Long id){
        try{
            User user = service.showUserById(id);
            return ResponseEntity.ok(user);
        } catch (ShowUserError e) {
            throw new ShowUserError(e.getMessage());
        }

    }


}

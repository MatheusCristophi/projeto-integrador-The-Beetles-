package com.Beetles.SystemPayout.backEnd.controller;

import com.Beetles.SystemPayout.backEnd.entity.User;
import com.Beetles.SystemPayout.backEnd.exceptions.DeleteUserError;
import com.Beetles.SystemPayout.backEnd.exceptions.SaveUserException;
import com.Beetles.SystemPayout.backEnd.exceptions.ShowUserError;
import com.Beetles.SystemPayout.backEnd.exceptions.UpdateUserError;
import com.Beetles.SystemPayout.backEnd.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class Controller {
    Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/saveuser")
    public ResponseEntity<User> saveUsers(@RequestBody User user){
        try{
            User savedUser = service.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new SaveUserException(e.getMessage());
        }
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> showAllUsers(){
        try{
            List<User> user = service.showUsers();
            return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
            throw new ShowUserError(e.getMessage());
        }
    }

    @GetMapping("/getuserid/{id}")
    public ResponseEntity<User> showIdUser(@PathVariable Long id){
        try{
            User user = service.showUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            throw new ShowUserError(e.getMessage());
        }

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        try{
            User userUp = service.updateUser(id, user);
            return new ResponseEntity<>(userUp, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new UpdateUserError(e.getMessage());
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        try{
            service.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.GONE);
    } catch (RuntimeException e) {
            throw new DeleteUserError(e.getMessage());
        }
    }
}

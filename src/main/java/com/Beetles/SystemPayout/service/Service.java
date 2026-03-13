package com.Beetles.SystemPayout.service;

import com.Beetles.SystemPayout.entity.User;
import com.Beetles.SystemPayout.exceptions.DeleteUserError;
import com.Beetles.SystemPayout.exceptions.SaveUserException;
import com.Beetles.SystemPayout.exceptions.ShowUserError;
import com.Beetles.SystemPayout.exceptions.UpdateUserError;
import com.Beetles.SystemPayout.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<User> showUsers(){
        try {
            return repository.findAll();
        } catch (ShowUserError e) {
            throw new ShowUserError(e.getMessage());
        }
    }

    public User showUserById(Long id){
        try{
            return repository.findById(id)
                    .orElseThrow(()-> new RuntimeException("Id not exist"));
        } catch (ShowUserError e) {
            throw new ShowUserError(e.getMessage());
        }
    }

    public User saveUser(User user){
        try {
            return repository.save(user);
        } catch (SaveUserException e) {
            throw new SaveUserException(e.getMessage());
        }
    }

    public void deleteUserById(Long id){
        try{repository.deleteById(id);
    } catch (DeleteUserError e) {
            throw new DeleteUserError(e.getMessage());
        }
    }

    public User updateUser(Long id, User user){
        User userExist = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id Not Exist"));
        try {
            user.setName(userExist.getName());
            user.setEmail(userExist.getEmail());
            user.setPassword(userExist.getPassword());
            return repository.save(user);
        } catch (UpdateUserError e) {
            throw new UpdateUserError(e.getMessage());
        }
    }
}

package com.example.obhibernateproyecto.controller;

import com.example.obhibernateproyecto.dao.UserDAO;
import com.example.obhibernateproyecto.entities.User;
import com.example.obhibernateproyecto.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    private UserDAO userDAO;

    public UserController(UserRepository userRepository,UserDAO userDAO){
        this.userRepository = userRepository;
        this.userDAO = userDAO;
    }

    @GetMapping("/api/users")
    private List<User> findAll(){
        return this.userRepository.findAll();
    }

    @GetMapping("/api/users/active")
    private List<User> findAllActive(){
        return this.userDAO.findAllActive();
    }

    @PostMapping("/api/users")
    private User create(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/api/users")
    private User update(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    private User delete(@PathVariable Long id){
        if(this.userRepository.existsById(id))
            this.userRepository.deleteById(id);
        return null;
    }
}

package com.example.SpringLesson3.controller;

import com.example.SpringLesson3.domain.User;
import com.example.SpringLesson3.repository.UserRepository;
import com.example.SpringLesson3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    RegistrationService registrationService;
    UserRepository repository;

    @Autowired
    public UserController(RegistrationService regService, UserRepository repository) {
        this.registrationService = regService;
        this.repository = repository;
    }


    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getUserRepository().users;
    }


    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "Add user";

    }

    @PostMapping("/params")
    public String addUserFromParam(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) Integer age,
                                   @RequestParam(required = false) String email){
        {
            registrationService.processRegistration(name,age,email);
            return "User add from param";
        }
    }
}


package com.example.SpringLesson3.controller;

import com.example.SpringLesson3.domain.User;
import com.example.SpringLesson3.repository.UserRepository;
import com.example.SpringLesson3.services.DataProcessingService;
import com.example.SpringLesson3.services.RegistrationService;
import com.example.SpringLesson3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    UserRepository repository;
    DataProcessingService service;
    UserService userService;
    RegistrationService registrationService;

    @Autowired
    public TaskController(UserRepository repository, DataProcessingService service) {
        this.repository = repository;
        this.service = service;

    }


    @GetMapping
    public List<String> getTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(repository.getUsers());
    }

    //add methods filter calc
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(repository.getUsers(), age);
    }

    @GetMapping("/calc")
    public double getAverageAge() {
        return service.calculateAverageAge(repository.getUsers());
    }
//    @PostMapping("/add")
//    public String userAddFromParam(
//        @RequestParam String name,
//        @RequestParam int age,
//        @RequestParam String email){
//        return registrationService.processRegistration(name,age,email);
//    }
}

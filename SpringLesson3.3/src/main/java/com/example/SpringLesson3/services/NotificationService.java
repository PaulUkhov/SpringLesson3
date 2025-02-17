package com.example.SpringLesson3.services;

import com.example.SpringLesson3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
RegistrationService registrationService;
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
    public void showNewUser(){
        System.out.println("Добавлен новый пользователь " + registrationService.processRegistration("Paul",25,"example@gmail.com"));
    }
}
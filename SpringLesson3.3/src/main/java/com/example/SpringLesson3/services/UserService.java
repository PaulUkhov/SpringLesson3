package com.example.SpringLesson3.services;

import com.example.SpringLesson3.domain.User;
import com.example.SpringLesson3.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NotificationService notificationService;
    UserRepository repository;

    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User addUser(User user) {
        repository.getUsers().add(user);


        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
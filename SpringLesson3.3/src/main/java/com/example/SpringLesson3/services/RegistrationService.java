package com.example.SpringLesson3.services;

import com.example.SpringLesson3.domain.User;
import com.example.SpringLesson3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //fields  - UserService NotificationService DataProcessingService
    //method - processRegistration
UserRepository repository;
    UserService userService;
    NotificationService notificationService;
    DataProcessingService dataProcessingService;
@Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

public String processRegistration(String name,int age,String email){
    User user = new User();
    user.setName(name);
    user.setAge(age);
    user.setEmail(email);
    repository.getUsers().add(user);
    return user.toString();
}

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void setDataProcessingService(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }
}

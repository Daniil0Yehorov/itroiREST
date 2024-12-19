package com.example.itroiREST.Service.Interface;

import com.example.itroiREST.entity.User;

import java.util.List;

public interface userService {

    User getUserById(int userId);
    void createUser(User user);
    void updateUser(int userId, User user);
    void deleteUser(int userId);
    User authenticate(String login, String password);
    int generateUniqueUserId();
    List<User> getAllUsers();
}

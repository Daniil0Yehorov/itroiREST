package com.example.itroiREST.Service.Implementation;

import com.example.itroiREST.Service.Interface.cartService;
import com.example.itroiREST.Service.Interface.userService;
import com.example.itroiREST.entity.Cart;
import com.example.itroiREST.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements userService {
    private final Map<Integer, User> userDatabase = new HashMap<>();
    private int userIdCounter = 1;


    @Override
    public User getUserById(int userId) {
        System.out.println("Отримання користувача з ID: " + userId);
        return userDatabase.get(userId);
    }

    @Override
    public void createUser(User user) {
        user.setId(userIdCounter++);
        userDatabase.put(user.getId(), user);
        System.out.println("Створено користувача: " + user);
    }

    @Override
    public void updateUser(int userId, User user) {
        if (userDatabase.containsKey(userId)) {
            user.setId(userId);
            userDatabase.put(userId, user);
            System.out.println("Оновлено користувача з ID: " + userId);
        } else {
            System.out.println("Користувача з ID: " + userId + " не знайдено.");
        }
    }

    @Override
    public void deleteUser(int userId) {
        if (userDatabase.remove(userId) != null) {
            System.out.println("Видалено користувача з ID: " + userId);
        } else {
            System.out.println("Користувача з ID: " + userId + " не знайдено.");
        }
    }

    @Override
    public User authenticate(String login, String password) {
        User user = userDatabase.values().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        System.out.println(user != null ? "Авторизація успішна для: " + login : "Авторизація не вдалася для: " + login);
        return user;
    }

    @Override
    public int generateUniqueUserId() {
        System.out.println("Генерація унікального ID користувача.");
        return userIdCounter++;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Отримання списку всіх користувачів.");
        return new ArrayList<>(userDatabase.values());
    }
}
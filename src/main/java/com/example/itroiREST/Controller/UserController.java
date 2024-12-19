package com.example.itroiREST.Controller;

import com.example.itroiREST.Service.Interface.userService;

import com.example.itroiREST.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private userService uService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        return uService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        uService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        uService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        uService.deleteUser(id);
    }
}
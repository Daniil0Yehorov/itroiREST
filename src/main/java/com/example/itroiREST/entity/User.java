package com.example.itroiREST.entity;


import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String type;
    private String login;
    private String password;
    private String name;
    private String phone;
    private String email;

    public User(){}

    public User(int id,String type,String login,String password,String name,String phone,String email)
    {
        this.id = id;
        this.type = type;
        this.login = login;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
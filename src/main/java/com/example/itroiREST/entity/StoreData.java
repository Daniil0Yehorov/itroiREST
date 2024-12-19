package com.example.itroiREST.entity;

import java.io.Serializable;
import java.util.List;

public class StoreData implements Serializable {
    private List<Product> products;
    private List<Cart> carts;
    private List<User> users;
    public StoreData(){}
    public StoreData(List<Product> products, List<Cart> carts, List<User> users)
    {
        this.products=products;
        this.carts=carts;
        this.users=users;
    }
    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Cart> getCarts() {
        return carts;
    }
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
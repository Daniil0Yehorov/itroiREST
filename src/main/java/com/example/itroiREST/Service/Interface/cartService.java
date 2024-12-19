package com.example.itroiREST.Service.Interface;

import com.example.itroiREST.entity.Cart;


import java.util.List;


public interface cartService {
    void addProductToCart(int userId, int productId);
    Cart getCartByUserId(int userId);
    void removeProductFromCart(int userId, int productId);
    Cart checkout(int userId);
    List<Cart> getAllCarts();
    void addCart(Cart cart);
    void removeCart(int userId);

}

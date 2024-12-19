package com.example.itroiREST.Service.Implementation;

import com.example.itroiREST.Service.Interface.cartService;
import com.example.itroiREST.Service.Interface.productService;
import com.example.itroiREST.entity.Cart;
import com.example.itroiREST.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements cartService {

    private final Map<Integer, Cart> cartDatabase = new HashMap<>();

    @Autowired
    private productService pService;

    @Override
    public void addProductToCart(int userId, int productId) {
        Cart cart = cartDatabase.computeIfAbsent(userId, id -> new Cart());
        cart.setUserId(userId);
        Product product = pService.getProductById(productId);
        if (product != null && !cart.getProductIds().contains(productId)) {
            cart.getProductIds().add(productId);
            cart.setTotalAmount(cart.getTotalAmount() + product.getPrice());
            System.out.println("Додано продукт з ID: " + productId + " до кошика користувача з ID: " + userId);
        } else {
            System.out.println("Продукт з ID: " + productId + " не знайдено або вже в кошику.");
        }
    }

    @Override
    public void removeProductFromCart(int userId, int productId) {
        Cart cart = cartDatabase.get(userId);
        if (cart != null && cart.getProductIds().remove(Integer.valueOf(productId))) {
            Product product = pService.getProductById(productId);
            if (product != null) {
                cart.setTotalAmount(cart.getTotalAmount() - product.getPrice());
                System.out.println("Видалено продукт з ID: " + productId + " з кошика користувача з ID: " + userId);
            }
        } else {
            System.out.println("Продукт з ID: " + productId + " не знайдено в кошику.");
        }
    }

    @Override
    public Cart getCartByUserId(int userId) {
        System.out.println("Отримання кошика для користувача з ID: " + userId);
        return cartDatabase.getOrDefault(userId, new Cart());
    }

    @Override
    public Cart checkout(int userId) {
        Cart cart = cartDatabase.get(userId);
        if (cart != null) {
            cart.setStatus("Оформлений");
            System.out.println("Кошик користувача з ID: " + userId + " успішно оформлений.");
        }
        return cart;
    }

    @Override
    public List<Cart> getAllCarts() {
        System.out.println("Отримання всіх кошиків.");
        return new ArrayList<>(cartDatabase.values());
    }

    @Override
    public void addCart(Cart cart) {
        cartDatabase.put(cart.getUserId(), cart);
        System.out.println("Додано кошик для користувача з ID: " + cart.getUserId());
    }

    @Override
    public void removeCart(int userId) {
        if (cartDatabase.remove(userId) != null) {
            System.out.println("Видалено кошик для користувача з ID: " + userId);
        } else {
            System.out.println("Кошик для користувача з ID: " + userId + " не знайдено.");
        }
    }
}
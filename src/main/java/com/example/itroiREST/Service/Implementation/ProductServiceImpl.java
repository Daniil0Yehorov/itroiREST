package com.example.itroiREST.Service.Implementation;

import com.example.itroiREST.Service.Interface.productService;
import com.example.itroiREST.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements productService {
    private final Map<Integer, Product> productDatabase = new HashMap<>();
    private int productIdCounter = 1;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("Отримання списку всіх продуктів.");
        return new ArrayList<>(productDatabase.values());
    }

    @Override
    public Product getProductById(int productId) {
        System.out.println("Отримання продукту з ID: " + productId);
        return productDatabase.get(productId);
    }

    @Override
    public void addProduct(Product product) {
        product.setId(productIdCounter++);
        productDatabase.put(product.getId(), product);
        System.out.println("Додано продукт: " + product);
    }

    @Override
    public void updateProduct(Product product) {
        productDatabase.put(product.getId(), product);
        System.out.println("Оновлено продукт: " + product);
    }

    @Override
    public void deleteProduct(int productId) {
        if (productDatabase.remove(productId) != null) {
            System.out.println("Видалено продукт з ID: " + productId);
        } else {
            System.out.println("Продукт з ID: " + productId + " не знайдено.");
        }
    }
}
package com.example.itroiREST.Service.Interface;


import com.example.itroiREST.entity.Product;

import java.util.List;

public interface productService {

    List<Product> getAllProducts();
    Product getProductById(int productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
}

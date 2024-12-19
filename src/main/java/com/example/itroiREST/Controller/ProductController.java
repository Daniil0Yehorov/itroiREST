package com.example.itroiREST.Controller;

import com.example.itroiREST.Service.Interface.productService;
import com.example.itroiREST.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private productService pService;

    @GetMapping
    public List<Product> getAllProducts() {
        return pService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return pService.getProductById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        pService.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        pService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        pService.deleteProduct(id);
    }
}
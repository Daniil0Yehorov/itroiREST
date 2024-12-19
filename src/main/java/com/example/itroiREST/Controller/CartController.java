package com.example.itroiREST.Controller;
import com.example.itroiREST.entity.Cart;
import com.example.itroiREST.Service.Interface.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private cartService cService;

    @PostMapping("/{userId}/products/{productId}")
    public void addProductToCart(@PathVariable int userId, @PathVariable int productId) {
        cService.addProductToCart(userId, productId);
    }

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) {
        return cService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/checkout")
    public Cart checkout(@PathVariable int userId) {
        return cService.checkout(userId);
    }
}
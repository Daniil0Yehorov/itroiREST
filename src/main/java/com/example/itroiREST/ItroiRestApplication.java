package com.example.itroiREST;

import com.example.itroiREST.Service.Implementation.CartServiceImpl;
import com.example.itroiREST.Service.Implementation.ProductServiceImpl;
import com.example.itroiREST.Service.Implementation.UserServiceImpl;
import com.example.itroiREST.Service.Interface.cartService;
import com.example.itroiREST.Service.Interface.productService;
import com.example.itroiREST.Service.Interface.userService;
import com.example.itroiREST.entity.Cart;
import com.example.itroiREST.entity.Product;
import com.example.itroiREST.entity.StoreData;
import com.example.itroiREST.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ItroiRestApplication {
	public static void main(String[] args) {SpringApplication.run(ItroiRestApplication.class, args);}
}
@Component
class DataLoader implements CommandLineRunner {

	private final cartService cartService;
	private final productService productService;
	private final userService userService;

	public DataLoader(cartService cartService, productService productService, userService userService) {
		this.cartService = cartService;
		this.productService = productService;
		this.userService = userService;
	}

	@Override
	public void run(String... args) {
		User user1 = new User(1, "користувач", "user123", "password123", "Іван Петров", "+380123456789", "ivan.petrov@example.com");
		User user2 = new User(2, "адмін", "admin123", "adminpass", "Ольга Коваленко", "+380987654321", "olga.kovalenko@example.com");
		Product product1 = new Product(1, "Сухий корм для собак", "Корм преміум класу для дорослих собак", 500.0, "Собаки", 100);
		Product product2 = new Product(2, "Мокрий корм для котів", "Консерви для дорослих котів", 200.0, "Коти", 50);
		Product product3 = new Product(3, "Іграшка для гризунів", "Дерев'яна іграшка для зубів", 50.0, "Гризуни", 30);
		List<Integer> productIds1 = new ArrayList<>(Arrays.asList(1, 2));
		Cart cart1 = new Cart(1, productIds1, 700.0, "active");

		List<Integer> productIds2 = new ArrayList<>(Arrays.asList(3));
		Cart cart2 = new Cart(2, productIds2, 50.0, "active");

		userService.createUser(user1);
		userService.createUser(user2);

		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);

		cartService.addCart(cart1);
		cartService.addCart(cart2);
	}
}

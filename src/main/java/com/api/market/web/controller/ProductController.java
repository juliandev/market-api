package com.api.market.web.controller;

import com.api.market.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v0")
public class ProductController {

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return null;
	}
	
	@GetMapping("/products/{product-id}")
	public ResponseEntity<Product> getProduct(@PathVariable("product-id") int productId) {
		return null;
	}

	@GetMapping("/products/category/{category-id}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("category-id") int categoryId) {
		return null;
	}

	@PostMapping("/products")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return null;
	}
	
	@DeleteMapping("/products/{product-id}")
	public ResponseEntity delete(@PathVariable("product-id") int productId) {
		return null;
	}

}

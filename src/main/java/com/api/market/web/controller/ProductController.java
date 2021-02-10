package com.api.market.web.controller;

import com.api.market.domain.Product;
import com.api.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v0")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/products/{product-id}")
	public ResponseEntity<Product> getProduct(@PathVariable("product-id") int productId) {
		return productService.getProduct(productId)
			.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/products/category/{category-id}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("category-id") int categoryId) {
		return productService.getByCategory(categoryId)
			.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/products")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{product-id}")
	public ResponseEntity delete(@PathVariable("product-id") int productId) {
		return productService.delete(productId) ? 
			new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}

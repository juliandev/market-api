package com.api.market.domain.service;

import com.api.market.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	public List<Product> getAllProducts() {
		return null;
	}

	public Optional<Product> getProduct(int productId) {
		return null;
	}

	public Optional<List<Product>> getByCategory(int categoryId) {
		return null;
	}

	public Product save(Product product) {
		return null;
	}

	public Boolean delete(int productId) {
		return null;
	}

}

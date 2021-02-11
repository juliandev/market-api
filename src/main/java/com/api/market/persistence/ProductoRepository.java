package com.api.market.persistence;

import com.api.market.domain.Product;
import com.api.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		return null;
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return null;
	}

	@Override
	public Product save(Product product) {
		return null;
	}

	@Override
	public void delete(int productId) {
		
	}

}

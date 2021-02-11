package com.api.market.domain.repository;

import com.api.market.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

	List<Product> getAllProducts();
	Optional <List<Product>> getByCategory(int categoryId);
	Optional <Product> getProduct(int productId);
	Product save(Product product);
	void delete(int productId);

}

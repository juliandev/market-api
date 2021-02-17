package com.api.market.persistence;

import javax.annotation.Resource;

import com.api.market.domain.Product;
import com.api.market.domain.repository.ProductRepository;
import com.api.market.persistence.crud.ProductoCrudRepository;
import com.api.market.persistence.entity.Producto;
import com.api.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository productoCrudRepository;

	@Resource(name = "productMapperV0")
	private ProductMapper mapper;

	@Override
	public List<Product> getAllProducts() {
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}

	@Override
	public void delete(int productId) {
		productoCrudRepository.deleteById(productId);		
	}

}

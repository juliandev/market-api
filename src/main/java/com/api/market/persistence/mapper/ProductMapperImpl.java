package com.api.market.persistence.mapper;

import com.api.market.domain.Category;
import com.api.market.domain.Product;
import com.api.market.persistence.entity.Categoria;
import com.api.market.persistence.entity.Producto;
import com.api.market.persistence.mapper.ProductMapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "productMapperV0")
public class ProductMapperImpl implements ProductMapper {

	@Override
	public Product toProduct(Producto producto) {
		Product product = null;
		if (producto != null) {
			product = new Product();
			product.setProductId(producto.getIdProducto());
			product.setName(producto.getNombre());
			product.setCategoryId(producto.getIdCategoria());
			product.setPrice(producto.getPrecioVenta());
			product.setStock(producto.getCantidadStock());
			product.setActive(producto.getEstado());
			if (producto.getCategoria() != null) {
				Category category = new Category();
				category.setCategoryId(producto.getCategoria().getIdCategoria());
				category.setCategory(producto.getCategoria().getDescripcion());
				category.setActive(producto.getCategoria().getEstado());
				product.setCategory(category);
			}
		}
		return product;
	}

	@Override
	public List<Product> toProducts(List<Producto> productos) {
		List<Product> products = null;
		if (productos != null) {
			products = new ArrayList<Product>();
			for (Producto producto : productos) {
				Product product = new Product();
				product.setProductId(producto.getIdProducto());
				product.setName(producto.getNombre());
				product.setCategoryId(producto.getIdCategoria());
				product.setPrice(producto.getPrecioVenta());
				product.setStock(producto.getCantidadStock());
				product.setActive(producto.getEstado());
				if (producto.getCategoria() != null) {
					Category category = new Category();
					category.setCategoryId(producto.getCategoria().getIdCategoria());
					category.setCategory(producto.getCategoria().getDescripcion());
					category.setActive(producto.getCategoria().getEstado());
					product.setCategory(category);
				}
				products.add(product);
			}
		}
		return products;
	}
	
	@Override
	public Producto toProducto(Product product) {
		Producto producto = null;
		if (product != null) {
			producto = new Producto();
			producto.setIdProducto(product.getProductId());
			producto.setNombre(product.getName());
			producto.setIdCategoria(product.getCategoryId());
			producto.setPrecioVenta(product.getPrice());
			producto.setCantidadStock(product.getStock());
			producto.setEstado(product.isActive());
			// Falta categoría
		}
		return producto;
	}

}

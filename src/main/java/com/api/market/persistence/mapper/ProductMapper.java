package com.api.market.persistence.mapper;

import com.api.market.domain.Product;
import com.api.market.persistence.entity.Producto;
import java.util.List;

public interface ProductMapper {

	Product toProduct(Producto producto);
	List<Product> toProducts(List<Producto> productos);
	Producto toProducto(Product product);

}

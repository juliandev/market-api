package con.api.market.persistence.mapper;

import com.api.market.domain.Product;
import com.api.market.persistence.entity.Producto;
import com.api.market.persistence.mapper.ProductMapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "productMapperV0")
public class ProductMapperImpl implements ProductMapper {

	@Override
	public Product toProduct(Producto producto) {
		return null;
	}

	@Override
	public List<Product> toProducts(List<Producto> productos) {
		return null;
	}
	
	@Override
	public Producto toProducto(Product product) {
		return null;
	}

}
